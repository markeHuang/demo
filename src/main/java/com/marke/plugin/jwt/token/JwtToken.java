package com.marke.plugin.jwt.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Jwt令牌
 *
 * @author marke.huang
 * @date 2018/11/17 22:26
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
