package com.ldx.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Encrypt {
    public static String md5(String password,String username){
        String s = new Md5Hash(password, username, 2).toString();
        return s;
    }

    public static void main(String[] args) {
        System.out.println(MD5Encrypt.md5("123456", "haha"));
    }
}
