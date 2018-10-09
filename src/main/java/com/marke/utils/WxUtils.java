package com.marke.utils;

import com.marke.constant.GlobalConstants;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 微信工具类
 *
 * @author jiangming.huang
 * @date 2018/10/9 0009 下午 2:58
 */
public class WxUtils {

    /**
     * 校验请求来源为微信
     *
     * @param signature 密文
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param token     接口配置token
     * @return boolean
     * @author marke.huang
     * @date 2018/9/26 0026 下午 4:33
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce, String token) {
        // 从请求中（也就是微信服务器传过来的）拿到的token, timestamp, nonce
        String[] arr = {token, timestamp, nonce};
        // 1.将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        try {
            // 2.将三个参数字符串拼接成一个字符串进行sha1加密
            StringBuilder content = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                content.append(arr[i]);
            }
            MessageDigest md = MessageDigest.getInstance(GlobalConstants.SecureHashAlgorithm.SHA_1);
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


}
