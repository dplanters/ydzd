package com.gndc.core.mapper.simple;

import com.alibaba.fastjson.JSONObject;
import com.gndc.core.CoreApplication;
import com.gndc.core.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 景凯辉
 * @date 2018/11/9
 * @mail kaihuijing@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class UserModelMapperTest {

    @Resource
    private ProductMapper productMapper;


    @Test
    public void selectOneByProperty() {
        Product product = productMapper.selectByPrimaryKey(134);
        System.out.println(JSONObject.toJSONString(product, true));
    }

}