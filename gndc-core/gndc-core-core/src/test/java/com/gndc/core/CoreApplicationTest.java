package com.gndc.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * @author jingkaihui
 * @since 2018/12/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@Slf4j
public class CoreApplicationTest {

    @Autowired
    private DruidDataSource druidDataSource;

    @Test
    public void dateSource() throws SQLException {
        log.info("方法名:{};参数:{};信息:{}", "dateSource", "[]",
                JSONObject.toJSONString(druidDataSource.getCreateCount(), true));
    }
}