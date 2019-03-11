package com.gndc.core.mapper.simple;

import com.alibaba.fastjson.JSONObject;
import com.gndc.core.CoreApplication;
import com.gndc.core.model.UserModel;
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
    private UserModelMapper userModelMapper;

    @Test
    public void insert() {
        UserModel userModel = new UserModel();
        userModel.setName("机智的小哪吒");
        userModel.setRealName("景凯辉");
        userModel.setAge((byte) 24);
        userModelMapper.insert(userModel);
    }

    @Test
    public void selectOneByProperty() {
        UserModel userModel = userModelMapper.selectOneByProperty("id", 12);
        System.out.println(JSONObject.toJSONString(userModel, true));
    }

    @Test
    public void selectCountByProperty() {
        int id = userModelMapper.selectCountExistByProperty("name", "机智的小哪吒0");
        System.out.println(id);
    }
}