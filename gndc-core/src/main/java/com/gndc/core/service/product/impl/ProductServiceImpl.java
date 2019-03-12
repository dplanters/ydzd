package com.gndc.core.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.HjException;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.ResultCode;
import com.gndc.common.api.utils.ValidateUtil;
import com.gndc.common.enums.admin.RightType;
import com.gndc.common.enums.common.DelType;
import com.gndc.common.enums.common.StatusType;
import com.gndc.common.enums.product.ProductDataType;
import com.gndc.common.enums.product.ProductStatus;
import com.gndc.common.model.Admin;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.utils.JsonUtil;
import com.gndc.core.api.product.*;
import com.gndc.core.mapper.simple.ProductDataMapper;
import com.gndc.core.mapper.simple.ProductHotMapper;
import com.gndc.core.mapper.simple.ProductMapper;
import com.gndc.core.mappers.*;
import com.gndc.core.model.Product;
import com.gndc.core.model.ProductData;
import com.gndc.core.model.ProductHot;
import com.gndc.core.service.product.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.SqlsCriteria;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;
import tk.mybatis.mapper.weekend.WeekendSqls;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer> implements IProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductDataMapper productDataMapper;
    @Resource
    private ProductHotMapper productHotMapper;

    @Override
    @RequestMapping("apProductList")
    public ResponseMessage<List<APProductListResponse>> apProductList(String requestStr) {
        APProductListRequest request = JsonUtil.getObject(requestStr, APProductListRequest.class);
        ResponseMessage<List<APProductListResponse>> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validate(request.getHeader());
            ValidateUtil.validateBean(request);

            Integer partnerId = request.getAdmin().getPartnerId();

            Weekend<Product> weekend = Weekend.of(Product.class);
            weekend.weekendCriteria()
                    .andEqualTo(Product::getPartnerId, partnerId)
                    .andEqualTo(Product::getIsDel, DelType.NORMAL.getCode());

            List<Product> products = productMapper.selectByExample(weekend);

            List<APProductListResponse> productDatas = new ArrayList<>();

            for (int i = 0; i < products.size(); i++) {
                ProductData pd = productDataMapper.selectOneByProperty("productId", products.get(i).getId());
                APProductListResponse apProductListResponse = APProductListResponseMapper.INSTANCE.convert(products.get(i), pd);
                productDatas.add(apProductListResponse);
            }
            response.setData(productDatas);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/aoProductList")
    public ResponseMessage<List<AOProductListResponse>> aoProductList(String requestStr) {
        AOProductListRequest request = JsonUtil.getObject(requestStr, AOProductListRequest.class);
        ResponseMessage<List<AOProductListResponse>> response = new ResponseMessage<>(request);

        try {
            PageInfo page = request.getHeader().getPage();
            ValidateUtil.validateBean(request);

            PageHelper.startPage(page.getStartRow(), page.getSize());
            List<AOProductListResponse> aoProductListResponses = productMapper.aoProductList(request);

            long total = productMapper.aoProductListCount(request);

            response.setData(aoProductListResponses);
            response.getHeader().getPage().setTotal(total);

            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/aoProductNameAll")
    public ResponseMessage<List<Product>> aoProductNameAll(String requestStr) {
        AOAllProductNameRequest request = JsonUtil.getObject(requestStr, AOAllProductNameRequest.class);
        ResponseMessage<List<Product>> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validateBean(request);

            Weekend<Product> weekend = Weekend.of(Product.class);
            weekend.weekendCriteria()
                    .andEqualTo(Product::getIsDel, DelType.NORMAL.getCode())
                    .andEqualTo(Product::getStatus, ProductStatus.ON_LINE.getCode());

            Integer partnerId = request.getPartnerId();
            if (partnerId != null) {
                weekend.weekendCriteria().andEqualTo(Product::getPartnerId, partnerId);
                weekend.and();
            }

            List<Product> products = productMapper.selectByExample(weekend);

            response.setData(products);

            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/aoProductAddModify")
    @Transactional
    public ResponseMessage<Integer> aoProductAddModify(String requestStr) {
        AOProductAddModifyRequest request = JsonUtil.getObject(requestStr, AOProductAddModifyRequest.class);
        ResponseMessage<Integer> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validate(request.getHeader());
            ValidateUtil.validateBean(request);

            AOProductDataModifyRequest aoProductDataRequest = request.getExtra();


            Product product = ProductMapping.INSTANCE.convert(request);
            ProductData productData = ProductDataMapping.INSTANCE.convert(aoProductDataRequest);
            if (request.getId() == null) {
                //新增
                request.setExtra(null);

                productMapper.insertSelective(product);

                productData.setProductId(product.getId());
                productData.setDataType(ProductDataType.AMOUNT.getCode());
                productDataMapper.insertSelective(productData);
            } else {
                //修改
                productMapper.updateByPrimaryKeySelective(product);

                Weekend<ProductData> weekend = Weekend.of(ProductData.class);
                weekend.weekendCriteria()
                        .andEqualTo(ProductData::getProductId, request.getId())
                        .andEqualTo(ProductData::getDataType, ProductDataType.AMOUNT.getCode());
                productDataMapper.updateByExampleSelective(productData, weekend);
            }

            response.setData(product.getId());
            return response;
        } catch (HjException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/aoProductDetail")
    public ResponseMessage<AOProductDetailResponse> aoProductDetail(String requestStr) {
        AOProductDetailRequest request = JsonUtil.getObject(requestStr, AOProductDetailRequest.class);
        ResponseMessage<AOProductDetailResponse> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validateBean(request);
            Product product = productMapper.selectByPrimaryKey(request.getId());

            Weekend<ProductData> weekend = Weekend.of(ProductData.class);
            weekend.weekendCriteria()
                    .andEqualTo(ProductData::getProductId, product.getId())
                    .andEqualTo(ProductData::getDataType, ProductDataType.AMOUNT.getCode());
            ProductData productData = productDataMapper.selectOneByExample(weekend);

            AOProductDetailResponse aoProductDetailResponse = AOProductDetailResponseMapper.INSTANCE.convert(product, productData);
            response.setData(aoProductDetailResponse);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/aoProductUpperAndLowerLine")
    public ResponseMessage<Boolean> aoProductUpperAndLowerLine(String requestStr) {
        AOUpperAndLowerLineRequest request = JsonUtil.getObject(requestStr, AOUpperAndLowerLineRequest.class);
        ResponseMessage<Boolean> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validateBean(request);
            Product product = productMapper.selectByPrimaryKey(request.getId());
            if (product == null) {
                response.createError(ResultCode.PRODUCT_NOT_EXIST);
                return response;
            }
            Byte upperAndLowerLine = request.getUpperAndLowerLine();
            if (upperAndLowerLine.equals(ProductStatus.ON_LINE.getCode())) {
                product.setStatus(ProductStatus.ON_LINE.getCode());
                product.setOnlineTime(new Date());
            } else {
                product.setStatus(ProductStatus.OFF_LINE.getCode());
                product.setOfflineTime(new Date());
            }
            boolean affected = productMapper.updateByPrimaryKey(product) == 1;
            response.setData(affected);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/aoProductDelete")
    public ResponseMessage<Boolean> aoProductDelete(String requestStr) {
        AOProductDeleteRequest request = JsonUtil.getObject(requestStr, AOProductDeleteRequest.class);
        ResponseMessage<Boolean> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validateBean(request);
            Product product = productMapper.selectByPrimaryKey(request.getId());
            if (product == null) {
                response.createError(ResultCode.PRODUCT_NOT_EXIST);
                return response;
            }

            if (product.getStatus().equals(ProductStatus.ON_LINE.getCode())) {
                response.createError(ResultCode.PRODUCT_ONLINE);
                return response;
            }
            product.setIsDel(DelType.IS_DEL.getCode());

            Weekend<ProductData> weekend = Weekend.of(ProductData.class);
            weekend.weekendCriteria()
                    .andEqualTo(ProductData::getProductId, request.getId());


            ProductData productData = new ProductData();
            productData.setStatus(StatusType.DISABLED.getCode());

            boolean affectedRows = productDataMapper.updateByExampleSelective(productData, weekend) > 0;

            boolean affected = productMapper.updateByPrimaryKey(product) == 1;
            response.setData(affectedRows && affected);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/aoProductHotList")
    public ResponseMessage<List<AOProductHotListResponse>> aoProductHotList(String requestStr) {
        AOProductHotListRequest request = JsonUtil.getObject(requestStr, AOProductHotListRequest.class);
        ResponseMessage<List<AOProductHotListResponse>> response = new ResponseMessage<>(request);

        try {
            PageInfo page = request.getHeader().getPage();
            ValidateUtil.validateBean(request);

            PageHelper.startPage(page.getStartRow(), page.getSize());
            List<AOProductHotListResponse> aoProductListResponses = productMapper.aoProductHotList(request);

            PageInfo<AOProductHotListResponse> pageInfo = new PageInfo<>(aoProductListResponses);
            response.getHeader().setPage(pageInfo);
            response.setData(aoProductListResponses);

            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/aoProductHotEdit")
    @Transactional
    public ResponseMessage<Integer> aoProductHotEdit(String requestStr) {
        AOProductHotEditRequest request = JsonUtil.getObject(requestStr, AOProductHotEditRequest.class);
        ResponseMessage<Integer> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validate(request.getHeader());
            ValidateUtil.validateBean(request);

            Admin admin = request.getAdmin();
            if (admin == null) {
                response.createError(ResultCode.SESSIONID_ISNULL);
                logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

            // 校验权限
            com.gndc.common.common.utils.VerifyRightUtil.verifyRight(admin, RightType.RIGHT_PLATFORM_PRODUCTHOT_EDIT);

            ProductHot productHot4Edit = ProductHotMapping.INSTANCE.convert(request);

            Product product = productMapper.selectByPrimaryKey(request.getProductId());
            if(product == null || !product.getStatus().equals(ProductStatus.ON_LINE.getCode())){
                response.createError(ResultCode.PRODUCTS_NOT_ONLINE);
                logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
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

                if (productHot4Edit.getStatus().equals(ProductStatus.ON_LINE.getCode())
                        && productHot.getStatus().equals(ProductStatus.ON_LINE.getCode())) {
//                    productHot4Edit.setOnlineTime(new Date());
                    response.createError(ResultCode.PRODUCTS_HOT_IS_ONLINE);
                    logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
                    return response;
                }

                productHot4Edit.setId(productHot.getId());
                if (productHot4Edit.getStatus().equals(ProductStatus.OFF_LINE.getCode())) {
                    productHot4Edit.setOfflineTime(new Date());
                }
                productHotMapper.updateByPrimaryKeySelective(productHot4Edit);
            } else {
                //新增
                if (productHot4Edit.getStatus().equals(ProductStatus.ON_LINE.getCode())) {
                    productHot4Edit.setOnlineTime(new Date());
                }
                if (productHot4Edit.getStatus().equals(ProductStatus.OFF_LINE.getCode())) {
                    productHot4Edit.setOfflineTime(new Date());
                }
                productHotMapper.insertSelective(productHot4Edit);
            }


            response.setData(productHot4Edit.getId());
            return response;
        } catch (HjException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

}
