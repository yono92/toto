package com.es.prj.toto.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;


@Component
public class EncryptUtil {


    public String getEncryptValue(String value, String salt, int stretchSize) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");



        for(int i=0; i < stretchSize; i++) {
            String temp = salt + value;
            md.update(temp.getBytes());
            value = byteToString(md.digest());
        }

        return value;
    }

    private String byteToString(byte[] digest) {
        StringBuilder sb = new StringBuilder();

        for(byte b: digest) {
            sb.append(String.format("%02x",b));
        }

        return sb.toString();
    }
}
