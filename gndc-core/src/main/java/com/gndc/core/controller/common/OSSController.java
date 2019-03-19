package com.gndc.core.controller.common;

import com.gndc.common.utils.JsonUtil;
import com.gndc.third.oss.UploadToOSS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
*  * Description: 上传文件到OSS
* User: chenzuozhou
* Date: 2019-02-23
* Time: 上午11:17
*/
@RestController
@RequestMapping("/upload")
public class OSSController {

   private static final Logger logger = LoggerFactory.getLogger(OSSController.class);

   /**
    * 上传文件调用接口
    *
    * @param request
    * @param httpRequest
    * @return
    * @Description
    * @author <a href="chenzuozhou@adpanshi.com">chenzuozhou</a>
    */
   @RequestMapping(value = "/uploadOneFileToOSS")
   @ResponseBody
   public String uploadOneFileToOSS(String request, HttpServletRequest httpRequest, MultipartFile uploadFile, String sessionId) {
       String fileOriginalName = uploadFile.getOriginalFilename();
       String fileType = fileOriginalName.substring(fileOriginalName.lastIndexOf(".") + 1);
       Map<String,String> result = null;
       try {
           result = UploadToOSS.uploadFileToOss(uploadFile, fileType);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return JsonUtil.toJSONString(result);
   }
}
