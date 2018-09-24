package com.marke.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 微信服务接入签名校验
 *
 * @author marke.huang
 * @date 2018/9/23 20:03
 */
public class WxSignUtils<main> {

    public static boolean checkSignature(String signature, String timestamp,String nonce) {

        // 与接口配置信息中的Token要一致
        String token = "284c16786bd28dbaca004fedb5badb55";
        // 从请求中（也就是微信服务器传过来的）拿到的token, timestamp, nonce
        String[] arr = { token, timestamp, nonce };
        // 1.将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        try {
            // 2.将三个参数字符串拼接成一个字符串进行sha1加密
            StringBuilder content = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                content.append(arr[i]);
            }
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            // 将加密字节数组转成16进制字符串
            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            String tmpStr = hexstr.toString();
            // 3.开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
            return tmpStr != null ? tmpStr.equals(signature) : false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        boolean cheack = WxSignUtils.checkSignature("2a89c3d9579fa17c1fc76ba27e29a66e0c166da8","1537715847","1422616836");
        System.out.println("boolean:" + cheack);
    }
}
