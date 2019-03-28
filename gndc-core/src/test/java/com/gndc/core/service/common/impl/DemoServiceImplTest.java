package com.gndc.core.service.common.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gndc.core.CoreApplication;
import com.gndc.core.model.Demo;
import com.gndc.core.service.common.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@Slf4j
public class DemoServiceImplTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void insert() {
        JSONObject extra = new JSONObject()
                .fluentPut("name", "张三")
                .fluentPut("age", 24)
                .fluentPut("salary", 28000)
                .fluentPut("hobby", new JSONArray()
                    .fluentAdd("打篮球")
                    .fluentAdd("唱歌")
                    .fluentAdd("跳舞"));
        Demo demo = new Demo().setExtra(extra);
        demoService.insertSelective(demo);
        log.info(demo.getId().toString());
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void selectOne() {
        Demo demo = demoService.selectByPrimaryKey(1110876168002867200L);
        JSONArray hobby = demo.getExtra().getJSONArray("hobby");
        log.info(JSONObject.toJSONString(hobby));
        log.info(JSONObject.toJSONString(demo, true));
    }

    @Test
    public void select() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void selectCount() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void existsWithPrimaryKey() {
    }

    @Test
    public void selectByIds() {
    }

    @Test
    public void deleteByIds() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectCountByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void insertList() {
    }

    @Test
    public void insertUseGeneratedKeys() {
    }

    @Test
    public void selectOneByProperty() {
    }

    @Test
    public void selectByProperty() {
    }

    @Test
    public void existsWithProperty() {
    }

    @Test
    public void selectCountByProperty() {
    }

    @Test
    public void selectAggregationByExample() {
    }

    @Test
    public void selectByIdList() {
    }

    @Test
    public void selectOneByExample() {
    }
}