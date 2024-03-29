package com.es.prj.toto.util;

import com.es.prj.toto.common.util.EncryptUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilTest {
    @Autowired
    private EncryptUtil encryptUtil;

    @Test
    public void encrypt() throws Exception {

        String encryptPwd = encryptUtil.getEncryptValue("password", "123");

        System.out.println("encryptPwd >>>> " + encryptPwd);
    }
}
