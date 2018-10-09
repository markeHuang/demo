package com.marke.remote.Config;

import org.springframework.stereotype.Service;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 证书信任管理器类
 *
 * @author marke.huang
 * @date 2018/10/9 0009 下午 3:54
 */
@Service
public class MyX509TrustManager implements X509TrustManager {

    /**
     * 检查客户端
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    /**
     * 检查服务端
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
