package com.gndc.core.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.DelEnum;
import com.gndc.common.enums.product.ProductDataTypeEnum;
import com.gndc.common.enums.product.ProductStatusEnum;
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
import com.gndc.core.model.Admin;
import com.gndc.core.model.Product;
import com.gndc.core.model.ProductData;
import com.gndc.core.model.ProductHot;
import com.gndc.core.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.Resource;
import java.io.Serializable;
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
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public List<APProductListResponse> productList(@Validated @RequestBody APProductListRequest request) {
        Integer partnerId = request.getAdmin().getPartnerId();

        Weekend<Product> weekend = Weekend.of(Product.class);
        weekend.weekendCriteria()
                .andEqualTo(Product::getPartnerId, partnerId)
                .andEqualTo(Product::getIsDel, DelEnum.NORMAL.getCode());

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
        PageInfo page = request.getHeader().getPage();

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AOProductListResponse> aoProductListResponses = productMapper.aoProductList(request);

        return aoProductListResponses;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer productAddModify(AOProductAddModifyRequest request) {
        AOProductDataModifyRequest aoProductDataRequest = request.getExtra();

        Product product = ProductMapping.INSTANCE.convert(request);
        ProductData productData = ProductDataMapping.INSTANCE.convert(aoProductDataRequest);
        if (request.getId() == null) {
            //新增
            productMapper.insertSelective(product);

            productData.setProductId(product.getId());
            productData.setDataType(ProductDataTypeEnum.AMOUNT.getCode());
            productDataMapper.insertSelective(productData);
        } else {
            //修改
            productMapper.updateByPrimaryKeySelective(product);

            Weekend<ProductData> weekend = Weekend.of(ProductData.class);
            weekend.weekendCriteria()
                    .andEqualTo(ProductData::getProductId, request.getId())
                    .andEqualTo(ProductData::getDataType, ProductDataTypeEnum.AMOUNT.getCode());
            productDataMapper.updateByExampleSelective(productData, weekend);
        }

        return product.getId();
    }

    @Override
    public AOProductDetailResponse productDetail(AOProductDetailRequest request) {
        Product product = productMapper.selectByPrimaryKey(request.getId());

        if (product == null) {
            logger.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.PRODUCT_NOT_EXIST);
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
    public Boolean productUpperAndLowerLine(AOUpperAndLowerLineRequest request) {
        Product product = productMapper.selectByPrimaryKey(request.getId());
        if (product == null) {
            logger.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.PRODUCT_NOT_EXIST);
        }
        Byte upperAndLowerLine = request.getUpperAndLowerLine();
        if (upperAndLowerLine.equals(ProductStatusEnum.ON_LINE.getCode())) {
            product.setStatus(ProductStatusEnum.ON_LINE.getCode());
            product.setOnlineTime(new Date());
        } else {
            product.setStatus(ProductStatusEnum.OFF_LINE.getCode());
            product.setOfflineTime(new Date());
        }
        boolean affected = productMapper.updateByPrimaryKey(product) == 1;

        return affected;
    }

    @Override
    public Boolean productDelete(AOProductDeleteRequest request) {
        Integer id = request.getId();
        Product product = productMapper.selectByPrimaryKey(id);
        if (product == null) {
            logger.warn("产品编号{}不存在或已下线", request.getId());
            throw new HjException(ResultCode.PRODUCT_NOT_EXIST);
        }

        if (product.getStatus().equals(ProductStatusEnum.ON_LINE.getCode())) {
            logger.warn("产品编号{}在线不允许删除", request.getId());
            throw new HjException(ResultCode.PRODUCT_ONLINE);
        }
        product.setIsDel(DelEnum.IS_DEL.getCode());

        Weekend<ProductData> weekend = Weekend.of(ProductData.class);
        weekend.weekendCriteria()
                .andEqualTo(ProductData::getProductId, id);

        boolean affectedRows = productDataMapper.deleteByExample(weekend) > 0;
        boolean affected = productMapper.deleteByPrimaryKey(id) == 1;
        return affectedRows && affected;
    }

    @Override
    public List<AOProductHotListResponse> productHotList(AOProductHotListRequest request) {
        PageInfo page = request.getHeader().getPage();

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AOProductHotListResponse> aoProductListResponses = productMapper.aoProductHotList(request);

        return aoProductListResponses;
    }

    @Override
    @Transactional
    public Integer productHotEdit(AOProductHotEditRequest request) {
        Admin admin = request.getAdmin();
        if (admin == null) {
            logger.warn("用户未登陆");
            throw new HjException(ResultCode.SESSIONID_ISNULL);
        }

        ProductHot productHot4Edit = ProductHotMapping.INSTANCE.convert(request);

        Product product = productMapper.selectByPrimaryKey(request.getProductId());
        if (product == null || !product.getStatus().equals(ProductStatusEnum.ON_LINE.getCode())) {
            logger.warn("产品未上线");
            throw new HjException(ResultCode.PRODUCTS_NOT_ONLINE);
        }
        productHot4Edit.setProductName(product.getName());

        //修改

        Weekend<ProductHot> weekend = Weekend.of(ProductHot.class);
        weekend.weekendCriteria()
                .andEqualTo(ProductHot::getProductId, request.getProductId());
        List<ProductHot> productHotTemps = productHotMapper.selectByExample(weekend);

        if (productHotTemps != null && productHotTemps.size() > 0) {
            //修改
            ProductHot productHot = productHotTemps.get(0);

            if (productHot4Edit.getStatus().equals(ProductStatusEnum.ON_LINE.getCode())
                    && productHot.getStatus().equals(ProductStatusEnum.ON_LINE.getCode())) {
                logger.warn("产品在线");
                throw new HjException(ResultCode.PRODUCTS_HOT_IS_ONLINE);
            }

            productHot4Edit.setId(productHot.getId());
            if (productHot4Edit.getStatus().equals(ProductStatusEnum.OFF_LINE.getCode())) {
                productHot4Edit.setOfflineTime(new Date());
            }
            productHotMapper.updateByPrimaryKeySelective(productHot4Edit);
        } else {
            //新增
            if (productHot4Edit.getStatus().equals(ProductStatusEnum.ON_LINE.getCode())) {
                productHot4Edit.setOnlineTime(new Date());
            }
            if (productHot4Edit.getStatus().equals(ProductStatusEnum.OFF_LINE.getCode())) {
                productHot4Edit.setOfflineTime(new Date());
            }
            productHotMapper.insertSelective(productHot4Edit);
        }

        return productHot4Edit.getId();
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
