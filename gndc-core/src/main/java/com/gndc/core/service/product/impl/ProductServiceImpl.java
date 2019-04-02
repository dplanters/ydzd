package com.gndc.core.service.product.impl;

import cn.hutool.core.util.ObjectUtil;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.OnlineStatusEnum;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.product.ProductDataTypeEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.admin.product.*;
import com.gndc.core.api.app.product.find.PFindProductRequest;
import com.gndc.core.api.app.product.find.PFindProductResponse;
import com.gndc.core.api.app.product.find.PProductStaticUV;
import com.gndc.core.api.app.product.hot.PHotProductResponse;
import com.gndc.core.api.partner.product.APProductListRequest;
import com.gndc.core.api.partner.product.APProductListResponse;
import com.gndc.core.mapper.simple.ProductDataMapper;
import com.gndc.core.mapper.simple.ProductHotMapper;
import com.gndc.core.mapper.simple.ProductMapper;
import com.gndc.core.mappers.*;
import com.gndc.core.model.Product;
import com.gndc.core.model.ProductData;
import com.gndc.core.model.ProductHot;
import com.gndc.core.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer> implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductDataMapper productDataMapper;
    @Resource
    private ProductHotMapper productHotMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<APProductListResponse> productList(@Validated @RequestBody APProductListRequest request) {
        Integer partnerId = request.getApAdmin().getPartnerId();

        Weekend<Product> weekend = Weekend.of(Product.class);
        weekend.weekendCriteria()
                .andEqualTo(Product::getPartnerId, partnerId)
                .andEqualTo(Product::getStatus, StatusEnum.NORMAL.getCode());

        List<Product> products = productMapper.selectByExample(weekend);

        List<APProductListResponse> productDatas = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            ProductData pd = productDataMapper.selectOneByProperty("productId", products.get(i).getId());
            APProductListResponse apProductListResponse = APProductListResponseMapper.INSTANCE.convert(products.get(i), pd);
            productDatas.add(apProductListResponse);
        }
        return productDatas;
    }

    @Override
    public List<AOProductListResponse> productList(AOProductListRequest request) {
        List<AOProductListResponse> aoProductListResponses = productMapper.aoProductList(request);
        return aoProductListResponses;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addProduct(AOProductAddRequest request) {
        AOProductDataRequest aoProductDataRequest = request.getExtra();

        Product product = ProductMapping.INSTANCE.convert(request);
        ProductData productData = ProductDataMapping.INSTANCE.convert(aoProductDataRequest);
        //新增
        productMapper.insertSelective(product);
        productData.setProductId(product.getId());
        productData.setDataType(ProductDataTypeEnum.AMOUNT.getCode());
        productDataMapper.insertSelective(productData);

        return product.getId();
    }

    @Override
    public Integer modifyProduct(AOProductModifyRequest request) {
        AOProductDataRequest aoProductDataRequest = request.getExtra();

        Product product = ProductMapping.INSTANCE.convert(request);
        ProductData productData = ProductDataMapping.INSTANCE.convert(aoProductDataRequest);
        productMapper.updateByPrimaryKeySelective(product);

        Weekend<ProductData> weekend = Weekend.of(ProductData.class);
        weekend.weekendCriteria()
                .andEqualTo(ProductData::getProductId, request.getId())
                .andEqualTo(ProductData::getDataType, ProductDataTypeEnum.AMOUNT.getCode());
        productDataMapper.updateByExampleSelective(productData, weekend);

        return product.getId();
    }

    @Override
    public AOProductDetailResponse productDetail(AOProductDetailRequest request) {
        Product product = productMapper.selectByPrimaryKey(request.getId());

        if (product == null) {
            logger.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }

        Weekend<ProductData> weekend = Weekend.of(ProductData.class);
        weekend.weekendCriteria()
                .andEqualTo(ProductData::getProductId, product.getId())
                .andEqualTo(ProductData::getDataType, ProductDataTypeEnum.AMOUNT.getCode());
        ProductData productData = productDataMapper.selectOneByExample(weekend);

        AOProductDetailResponse aoProductDetailResponse = AOProductDetailResponseMapper.INSTANCE.convert(product, productData);

        return aoProductDetailResponse;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean productUpperAndLowerLine(AOProductOnlineOrOfflineRequest request) {
        Product product = productMapper.selectByPrimaryKey(request.getId());
        if (ObjectUtil.isNull(product)) {
            logger.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }
        Byte upperAndLowerLine = request.getUpperAndLowerLine();
        if (upperAndLowerLine.equals(OnlineStatusEnum.ONLINE.getCode())) {
            product.setProductStatus(OnlineStatusEnum.ONLINE.getCode());
            product.setOnlineTime(new Date());
        } else {
            ProductHot productHot = productHotMapper.selectOneByProperty("productId", request.getId());
            if (ObjectUtil.isNotNull(productHot)) {
                //产品处于热推中，下线热推产品
                productHot.setHotStatus(OnlineStatusEnum.OFFLINE.getCode());
                productHotMapper.updateByPrimaryKeySelective(productHot);
            }

            product.setProductStatus(OnlineStatusEnum.OFFLINE.getCode());
            product.setOfflineTime(new Date());
        }
        boolean affected = productMapper.updateByPrimaryKey(product) == 1;

        return affected;
    }

    @Override
    public Boolean productDelete(AOProductDeleteRequest request) {
        Integer id = request.getId();
        Product originalProduct = productMapper.selectByPrimaryKey(id);
        if (originalProduct == null) {
            logger.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }

        if (originalProduct.getProductStatus().equals(OnlineStatusEnum.ONLINE.getCode())) {
            logger.warn("产品编号{}在线不允许删除", request.getId());
            throw new HjException(ResultCode.PRODUCT_ONLINE);
        }
        originalProduct.setStatus(StatusEnum.DELETE.getCode());

        Weekend<ProductData> weekend = Weekend.of(ProductData.class);
        weekend.weekendCriteria()
                .andEqualTo(ProductData::getProductId, id);

        Product product = new Product().setId(id).setStatus(StatusEnum.DELETE.getCode());
        boolean affectedRows = productDataMapper.deleteByExample(weekend) > 0;
        boolean affected = productMapper.updateByPrimaryKeySelective(product) == 1;
        return affectedRows && affected;
    }

    @Override
    public List<AOProductHotListResponse> productHotList(AOProductHotListRequest request) {

        List<AOProductHotListResponse> aoProductListResponses = productMapper.aoProductHotList(request);

        return aoProductListResponses;
    }

    @Override
    @Transactional
    public Integer productHotAdd(AOProductHotAddRequest request) {
        ProductHot productHot = ProductHotMapping.INSTANCE.convert(request);

        Product product = productMapper.selectByPrimaryKey(request.getProductId());

        if (ObjectUtil.isNull(product)) {
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }
        if (ObjectUtil.isNotNull(product) && !product.getProductStatus().equals(OnlineStatusEnum.ONLINE.getCode())) {
            logger.warn("产品未上线");
            throw new HjException(ResultCode.PRODUCTS_NOT_ONLINE);
        }
        productHot.setHotStatus(OnlineStatusEnum.ONLINE.getCode());
        productHot.setProductName(product.getName());
        productHot.setOnlineTime(new Date());
        //新增
        productHotMapper.insertSelective(productHot);
        return productHot.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer productHotOffline(AOProductHotOfflineRequest request) {
        ProductHot productHot = new ProductHot().setId(request.getId())
                .setHotStatus(OnlineStatusEnum.OFFLINE.getCode());
        //下线热推产品
        productHotMapper.updateByPrimaryKeySelective(productHot);
        return productHot.getId();
    }

    @Override
    public List<PHotProductResponse> selectPHotProductList() {
        return productMapper.selectPHotProductList();
    }

    @Override
    public List<PFindProductResponse> selectPFindProductList(PFindProductRequest findProductRequest) {
        return productMapper.selectPFindProductList(findProductRequest);
    }

    @Override
    public List<PProductStaticUV> staticProductUV(List<Integer> productIds, List<Byte> eventTypes) {
        return productMapper.staticProductUV(productIds, eventTypes);
    }

}
