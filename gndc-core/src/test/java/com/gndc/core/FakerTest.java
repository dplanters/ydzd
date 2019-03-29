package com.gndc.core;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSONObject;
import com.github.javafaker.Faker;
import com.gndc.common.utils.PwdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * @author jingkaihui
 * @since 2018/11/27
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class FakerTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        Faker faker = new Faker(Locale.CHINA);
        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        log.info(JSONObject.toJSONString(faker.address().city(), true));
        log.info(faker.friends().location());

    }

    @Test
    public void rsaTest() {
        KeyPair keyPair = SecureUtil.generateKeyPair(AsymmetricAlgorithm.RSA.getValue());
        String privateKeyStr = Base64.encode(keyPair.getPrivate().getEncoded());
        log.info(privateKeyStr);
        String publicKeyStr = Base64.encode(keyPair.getPublic().getEncoded());
        log.info(publicKeyStr);

        RSA rsa = SecureUtil.rsa(privateKeyStr, publicKeyStr);

        byte[] encrypt = rsa.encrypt("123456", KeyType.PublicKey);
        String encode = Base64.encode(encrypt);
        log.info(encode);
        byte[] decrypt = rsa.decrypt(Base64.decode(encode), KeyType.PrivateKey);
        log.info(StrUtil.str(decrypt, "UTF-8"));
    }

    @Test
    public void pwdTest() {
        String originalPassword = "123456";
        String encrypt = PwdUtil.encrypt(originalPassword);
        log.info("加密后的base64串:{}", encrypt);

        String decrypt = PwdUtil.decrypt(encrypt);
        log.info("解密后的原数据:{}", decrypt);

        assertEquals(originalPassword, decrypt);

        String passwordSign = RandomUtil.randomString(6);
        String md5Password = PwdUtil.passwordGenerate(decrypt, passwordSign);

        log.info("passwordSign:{}", passwordSign);
        log.info("数据库中存储的密码:{}", md5Password);
    }


}
