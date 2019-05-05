/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.controller.admin.product;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.admin.mappers.ProductIncmingConfigMapping;
import com.gndc.admin.service.product.productincomingconfig.ProductIncomingConfigService;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.admin.product.productincomingconfig.AOProductIncomingConfigAddRequest;
import com.gndc.common.api.admin.product.productincomingconfig.AOProductIncomingConfigIncomingInfoRequest;
import com.gndc.common.api.admin.product.productincomingconfig.AOProductIncomingConfigSearchRequest;
import com.gndc.common.api.admin.product.productincomingconfig.AOProductIncomingConfigUpdateRequest;
import com.gndc.common.dto.ProductIncomingConfigListDTO;
import com.gndc.common.dto.ProductIncomingConfigUpdateDTO;
import com.gndc.common.model.ProductIncomingConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/27  14:58
 */
@Slf4j
@RestController
@RequestMapping("/productIncomingConfig")
public class ProductIncomingConfigController {

    @Autowired
    private ProductIncomingConfigService productIncomingConfigService;
    @Autowired
    private ProductIncmingConfigMapping productIncmingConfigMapping;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody @Validated AOProductIncomingConfigAddRequest request){
        ResponseMessage responseMessage=new ResponseMessage();

        ProductIncomingConfig productIncomingConfig = productIncmingConfigMapping.convert(request);
        productIncomingConfig.setOperatorId(request.getAoAdmin().getId());

        //生效时间在当前时间之前  或者  等于当前时间
        if(productIncomingConfig.getEffectTime().before(new Date())
            ||productIncomingConfig.getEffectTime().equals(new Date())){
            productIncomingConfigService.insert(productIncomingConfig);
        }else{
            long delayTime = productIncomingConfig.getEffectTime().getTime() - DateUtil.date().getTime();
            DelayThread thread = new DelayThread(productIncomingConfig,delayTime);
            threadPoolTaskExecutor.execute(thread);
        }
        return responseMessage;
    }

    @PostMapping("/update")
    public ResponseMessage update(@RequestBody @Validated AOProductIncomingConfigUpdateRequest request){
        ResponseMessage responseMessage=new ResponseMessage();

        ProductIncomingConfig productIncomingConfig = productIncmingConfigMapping.convert(request);
        productIncomingConfig.setOperatorId(request.getAoAdmin().getId());

        //生效时间在当前时间之前  或者  等于当前时间
        if(productIncomingConfig.getEffectTime().before(new Date())
                ||productIncomingConfig.getEffectTime().equals(new Date())){
            productIncomingConfigService.updateByPrimaryKeySelective(productIncomingConfig);
        }else{
            long delayTime = productIncomingConfig.getEffectTime().getTime() - DateUtil.date().getTime();
            DelayThread thread = new DelayThread(productIncomingConfig,delayTime);
            threadPoolTaskExecutor.execute(thread);
        }
        return responseMessage;
    }


    @PostMapping("/getIncomingInfo")
    public ResponseMessage<ProductIncomingConfigUpdateDTO> getIncomingInfo(@RequestBody @Validated AOProductIncomingConfigIncomingInfoRequest request){
        ResponseMessage<ProductIncomingConfigUpdateDTO> responseMessage=new ResponseMessage();

        Integer countNewGuests = productIncomingConfigService.countNewGuests(request.getProductId());
        Integer countOldGuests = productIncomingConfigService.countOldGuests(request.getProductId());
        Integer countSameDayNewGuestsOrder = productIncomingConfigService.countSameDayNewGuestsOrder(request.getProductId());
        Integer countSameDayOldGuestsOrder = productIncomingConfigService.countSameDayOldGuestsOrder(request.getProductId());
        ProductIncomingConfig productIncomingConfig = productIncomingConfigService.selectOneByProperty(ProductIncomingConfig::getProductId, request.getProductId());

        ProductIncomingConfigUpdateDTO productIncomingConfigUpdateDTO=new ProductIncomingConfigUpdateDTO();
        productIncomingConfigUpdateDTO.setNewUser(countNewGuests);
        productIncomingConfigUpdateDTO.setOldUser(countOldGuests);
        productIncomingConfigUpdateDTO.setSameDayNewUser(countSameDayNewGuestsOrder);
        productIncomingConfigUpdateDTO.setSameDayOldUser(countSameDayOldGuestsOrder);
        productIncomingConfigUpdateDTO.setProductIncomingConfig(productIncomingConfig);

        responseMessage.setData(productIncomingConfigUpdateDTO);
        return responseMessage;
    }


    /**
     * 分页查询
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    @PostMapping("/selectProductIncomingConfigPage")
    public ResponseMessage selectPage(@RequestBody @Validated AOProductIncomingConfigSearchRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<ProductIncomingConfigListDTO> data = productIncomingConfigService.selectProductIncomingConfigPage(request);
        PageInfo<ProductIncomingConfigListDTO> pageInfo = new PageInfo<>(data);
        responseMessage.setData(data);
        responseMessage.setPage(pageInfo);
        return responseMessage;
    }









   class DelayThread implements Runnable{
       private ProductIncomingConfig productIncomingConfig;
       //毫秒
       private Long delay;

       public DelayThread(ProductIncomingConfig productIncomingConfig,Long delay) {
           this.productIncomingConfig = productIncomingConfig;
           this.delay = delay;
       }
       @Override
       public void run() {
           try {
               Thread.sleep(delay);
           } catch (InterruptedException e) {
               log.error("任务执行异常->"+delay+"---"+productIncomingConfig.toString(),e);
               return;
           }
           if(productIncomingConfig.getId()!=null){
               productIncomingConfigService.updateByPrimaryKeySelective(productIncomingConfig);
           }else{
               productIncomingConfigService.insert(productIncomingConfig);
           }
       }
   }
}
