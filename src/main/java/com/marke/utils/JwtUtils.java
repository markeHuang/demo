package com.marke.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.marke.constant.GlobalConstants;
import com.marke.constant.TimeoutConstants;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * JWT工具类 .<br>
 *
 * @author andy.sher
 * @version 0.1.0
 */
@Slf4j
public final class JwtUtils {

    private JwtUtils() {
    }

    /**
     * 手机号
     */
    private static final String MOBILEPHONE = "mobilephone";

    /**
     * 用户ID
     */
    private static final String USERID = "userid";

    /**
     * 校验token是否正确
     *
     * @param token       令牌
     * @param secret      用户的密码
     * @param mobilephone 手机号
     * @param userid      用户ID
     * @return 是否正确
     */
    public static String verify(String token, String secret, String mobilephone, String userid) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(MOBILEPHONE, mobilephone)
                    .withClaim(USERID, userid)
                    .build();
            verifier.verify(token);
            return GlobalConstants.Flag.SUCCESS;
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    /**
     * 获得token中的手机号
     *
     * @param token
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/17 22:21
     */
    public static String getMobilephone(String token) {
        if (StringUtils.isNotBlank(token)) {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(MOBILEPHONE).asString();
        }
        return "";
    }

    /**
     * 获得token中的用户ID .
     *
     * @param token
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/17 22:22
     */
    public static String getUserid(String token) {
        if (StringUtils.isNotBlank(token)) {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USERID).asString();
        }
        return StringUtils.EMPTY;
    }

    /**
     * 生成签名
     *
     * @param secret     用户的密码
     * @param mobilehone
     * @param userid
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/17 22:23
     */
    public static String sign(String secret, String mobilehone, String userid) {
        try {
            Date date = new Date(System.currentTimeMillis() + TimeoutConstants.TOKEN_TIMEOUT);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带用户信息
            return JWT.create()
                    .withClaim(MOBILEPHONE, mobilehone)
                    .withClaim(USERID, userid)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            log.error(JwtUtils.class.getName(), e);
        }
        return StringUtils.EMPTY;
    }

}
