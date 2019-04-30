package com.gndc.admin.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.gndc.third.oss.UploadToOSS;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/upload")
public class OSSController {

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
       return JSONObject.toJSONString(result);
   }
}
