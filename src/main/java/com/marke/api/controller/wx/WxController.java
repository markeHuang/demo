package com.marke.api.controller.wx;

import com.marke.utils.WxSignUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信接口服务类
 *
 * @author marke.huang
 * @date 2018/9/23 19:29
 */
@RestController
@RequestMapping(value = "/wx")
public class WxController {

    @GetMapping(value = "/cheackWx")
    public String getCheackWx(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
        @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr ) {
        // 验证是否是微信的请求
        if(WxSignUtils.checkSignature(signature, timestamp, nonce)){
            return echostr;
        }
        return null;
    }
}
