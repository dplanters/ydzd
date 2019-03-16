package com.gndc.core.controller.app.product;

import com.gndc.common.enums.product.ProductPeriodUnit;
import com.gndc.common.enums.user.UserEventsType;
import com.gndc.core.api.app.product.find.PFindProductResponse;
import com.gndc.core.api.app.product.find.PProductStaticUV;
import com.gndc.core.api.common.ResponseMessage;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.system.SystemOptionEnum;
import com.gndc.core.api.app.product.find.PFindProductRequest;
import com.gndc.core.api.app.product.hot.PHotProductResponse;
import com.gndc.core.api.common.CommonRequest;
import com.gndc.core.model.SystemOption;
import com.gndc.core.service.product.ProductService;
import com.gndc.core.service.sys.SystemOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.*;

/**
 * 客户端产品相关
 */
@RestController
@RequestMapping("/app/product")
public class PProductController {

    private static final String borrowAmount = "borrowAmount";

    @Autowired
    private ProductService productService;
    @Autowired
    private SystemOptionService systemOptionService;

    /**
     * 首页精选爆款
     *
     * @param commonRequest
     * @return
     */
    @PostMapping("/hot/productList")
    public ResponseMessage<List<PHotProductResponse>> hotProductList(@Validated @RequestBody CommonRequest commonRequest) {
        ResponseMessage<List<PHotProductResponse>> response = new ResponseMessage<>();
        PageInfo page = commonRequest.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<PHotProductResponse> pHotProductList = productService.selectPHotProductList();
        if(pHotProductList != null && pHotProductList.size() > 0){
            for (PHotProductResponse temp : pHotProductList) {
                //图片地址，先写死
                temp.setLogoUrl("http://gndc.chbitech.com/" + temp.getLogoUrl());
            }
        }
        PageInfo<PHotProductResponse> pageInfo = new PageInfo<>(pHotProductList);
        response.setData(pHotProductList);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        return response;
    }

    /**
     * 找贷款搜索配置项
     *
     * @return
     */
    @RequestMapping("/find/options")
    public ResponseMessage<Map<String, Object>> findProductOptions() {
        ResponseMessage<Map<String, Object>> response = new ResponseMessage<>();
        Map<String, String> optionMap = null;
        List<Map<String, String>> options = new ArrayList<>();

        // 查找系统配置
        Weekend<SystemOption> weekend = Weekend.of(SystemOption.class);
        weekend.selectProperties("optionKey", "optionValue");
        weekend.weekendCriteria()
                .andEqualTo(SystemOption::getOptionGroup, SystemOptionEnum.SEARCH_CRITERIA.getCode());
        List<SystemOption> systemOptions = systemOptionService.selectByExample(weekend);

        Iterator it = systemOptions.iterator();

        while (it.hasNext()) {
            SystemOption temp = (SystemOption) it.next();
            if (borrowAmount.equals(temp.getOptionKey())) {
                JSONObject jsStr = JSONObject.parseObject(temp.getOptionValue());
                JSONArray amount = jsStr.getJSONArray("amount");
                if (amount.size() > 0) {
                    for (int i = 0; i < amount.size(); i++) {
                        optionMap = new HashMap<>();
                        // 遍历 jsonArray 数组，把每一个对象转成 json 对象
                        JSONObject jsTemp = amount.getJSONObject(i);
                        // 得到 每个对象中的属性值
                        if (-1 == Integer.parseInt(String.valueOf(jsTemp.get("start")))) {
                            optionMap.put("amountStart", "-1");
                            optionMap.put("amountEnd", "-1");
                            optionMap.put("value", "金额不限");
                        } else {
                            String value = "";
                            if (0 == Integer.parseInt(String.valueOf(jsTemp.get("start")))) {
                                optionMap.put("amountStart", "0");
                                optionMap.put("amountEnd", String.valueOf(jsTemp.get("end")));
                                value = jsTemp.get("end") + "以下";
                            } else if (-2 == Integer.parseInt(String.valueOf(jsTemp.get("end")))) {
                                optionMap.put("amountStart", String.valueOf(jsTemp.get("start")));
                                optionMap.put("amountEnd", "-2");
                                value = jsTemp.get("start") + "以上";
                            } else {
                                value = jsTemp.get("start") + "-" + jsTemp.get("end");
                                optionMap.put("amountStart", String.valueOf(jsTemp.get("start")));
                                optionMap.put("amountEnd", String.valueOf(jsTemp.get("end")));
                            }
                            optionMap.put("value", value);
                        }
                        options.add(optionMap);
                    }
                }
                it.remove();
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("firstOption", options);
        resultMap.put("secondOption", systemOptions);
        response.setData(resultMap);
        return response;
    }

    /**
     * 找贷款产品列表
     *
     * @param findProductRequest
     * @return
     */
    @RequestMapping("/find/productList")
    public ResponseMessage<List<PFindProductResponse>> findProductList(@Validated @RequestBody PFindProductRequest findProductRequest) {
        ResponseMessage<List<PFindProductResponse>> response = new ResponseMessage<>();
        PageInfo page = findProductRequest.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<PFindProductResponse> pFindProductList = productService.selectPFindProductList(findProductRequest);
        if (pFindProductList != null && pFindProductList.size() > 0) {
            List<Integer> productIds = new ArrayList<>();
            List<Byte> eventTypes = new ArrayList<>();
            eventTypes.add(UserEventsType.BANNER_CLICK.getCode());
            eventTypes.add(UserEventsType.RECOMMEND_CLICK.getCode());
            eventTypes.add(UserEventsType.PRODUCT_CLICK.getCode());
            for (PFindProductResponse temp : pFindProductList) {
                productIds.add(temp.getProductId());
            }

            //统计申请数量
            List<PProductStaticUV> pProductStaticUVList = productService.staticProductUV(productIds, eventTypes);

            for (PFindProductResponse temp : pFindProductList) {

                if (pProductStaticUVList != null && pProductStaticUVList.size() > 0) {
                    for (int i = 0; i < pProductStaticUVList.size(); i++) {
                        if (temp.getProductId() == pProductStaticUVList.get(i).getProductId()) {
                            temp.setStaticUV(pProductStaticUVList.get(i).getStaticCount());
                        }
                    }
                }

                //图片地址，先写死
                temp.setLogoUrl("http://gndc.chbitech.com/" + temp.getLogoUrl());

                Integer minBorrowPeriod = temp.getMinBorrowPeriod();
                Integer maxBorrowPeriod = temp.getMaxBorrowPeriod();
                if (minBorrowPeriod == maxBorrowPeriod) {
                    temp.setPeriod(minBorrowPeriod + "个" + ProductPeriodUnit.fetchName(temp.getBorrowPeriodUnit()));
                } else {
                    temp.setPeriod(minBorrowPeriod + "-" + maxBorrowPeriod + "个" + ProductPeriodUnit.fetchName(temp.getBorrowPeriodUnit()));
                }
            }
        }

        PageInfo<PFindProductResponse> pageInfo = new PageInfo<>(pFindProductList);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        response.setData(pFindProductList);
        return response;
    }

}
