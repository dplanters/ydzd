package com.gndc.admin.service.product.impl;

import cn.hutool.core.util.ObjectUtil;
import com.gndc.admin.api.admin.product.*;
import com.gndc.admin.api.app.product.find.PFindProductRequest;
import com.gndc.admin.api.app.product.find.PFindProductResponse;
import com.gndc.admin.api.app.product.find.PProductStaticUV;
import com.gndc.admin.api.app.product.hot.PHotProductResponse;
import com.gndc.admin.api.partner.product.APProductListRequest;
import com.gndc.admin.api.partner.product.APProductListResponse;
import com.gndc.common.mapper.ProductDataMapper;
import com.gndc.common.mapper.ProductHotMapper;
import com.gndc.common.mapper.ProductMapper;
import com.gndc.admin.mappers.*;
import com.gndc.common.model.Product;
import com.gndc.common.model.ProductData;
import com.gndc.common.model.ProductHot;
import com.gndc.admin.service.product.ProductService;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.OnlineStatusEnum;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.product.ProductDataTypeEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer> implements ProductService {

    @Autowired
    private ProductDataMapping productDataMapping;

    @Autowired
    private ProductHotMapping productHotMapping;

    @Autowired
    private ProductMapping productMapping;

    @Autowired
    private APProductListResponseMapping apProductListResponseMapping;

    @Autowired
    private AOProductDetailResponseMapping aoProductDetailResponseMapping;
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
            ProductData pd = productDataMapper.selectOneByProperty(ProductData::getProductId, products.get(i).getId());
            APProductListResponse apProductListResponse = apProductListResponseMapping.convert(products.get(i), pd);
            productDatas.add(apProductListResponse);
        }
        return productDatas;
    }

    @Override
    public List<AOProductListResponse> productList(AOProductListRequest request) {
//        List<AOProductListResponse> aoProductListResponses = productMapper.aoProductList(request);
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addProduct(AOProductAddRequest request) {
        AOProductDataRequest aoProductDataRequest = request.getExtra();

        Product product = productMapping.convert(request);
        ProductData productData = productDataMapping.convert(aoProductDataRequest);
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

        Product product = productMapping.convert(request);
        ProductData productData = productDataMapping.convert(aoProductDataRequest);
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
            log.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }

        Weekend<ProductData> weekend = Weekend.of(ProductData.class);
        weekend.weekendCriteria()
                .andEqualTo(ProductData::getProductId, product.getId())
                .andEqualTo(ProductData::getDataType, ProductDataTypeEnum.AMOUNT.getCode());
        ProductData productData = productDataMapper.selectOneByExample(weekend);

        AOProductDetailResponse aoProductDetailResponse = aoProductDetailResponseMapping.convert(product, productData);

        return aoProductDetailResponse;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean productUpperAndLowerLine(AOProductOnlineOrOfflineRequest request) {
        Product product = productMapper.selectByPrimaryKey(request.getId());
        if (ObjectUtil.isNull(product)) {
            log.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }
        Byte upperAndLowerLine = request.getUpperAndLowerLine();
        if (upperAndLowerLine.equals(OnlineStatusEnum.ONLINE.getCode())) {
            product.setProductStatus(OnlineStatusEnum.ONLINE.getCode());
            product.setOnlineTime(new Date());
        } else {
            ProductHot productHot = productHotMapper.selectOneByProperty(ProductHot::getProductId, request.getId());
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
            log.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }

        if (originalProduct.getProductStatus().equals(OnlineStatusEnum.ONLINE.getCode())) {
            log.warn("产品编号{}在线不允许删除", request.getId());
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

//        List<AOProductHotListResponse> aoProductListResponses = productMapper.aoProductHotList(request);

        return null;
    }

    @Override
    @Transactional
    public Integer productHotAdd(AOProductHotAddRequest request) {
        ProductHot productHot = productHotMapping.convert(request);

        Product product = productMapper.selectByPrimaryKey(request.getProductId());

        if (ObjectUtil.isNull(product)) {
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }
        if (ObjectUtil.isNotNull(product) && !product.getProductStatus().equals(OnlineStatusEnum.ONLINE.getCode())) {
            log.warn("产品未上线");
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
//        return productMapper.selectPHotProductList();
        return null;
    }

    @Override
    public List<PFindProductResponse> selectPFindProductList(PFindProductRequest findProductRequest) {
//        return productMapper.selectPFindProductList(findProductRequest);
        return null;
    }

    @Override
    public List<PProductStaticUV> staticProductUV(List<Integer> productIds, List<Byte> eventTypes) {
//        return productMapper.staticProductUV(productIds, eventTypes);
        return null;
    }

}
