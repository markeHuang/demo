package com.marke.api.controller.wx;

import com.marke.utils.WxSignUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信接口服务类
 *
 * @author marke.huang
 * @date 2018/9/23 19:29
 */
@RestController
@RequestMapping(value = "/wx")
public class WxController {

    /**
     * 接收微信消息和事件
     *
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/9/26 0026 下午 4:29
     */
    @GetMapping(value = "/getWxMsgOrEvent")
    public String getWxMsgOrEvent(HttpServletRequest request) {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        //  随机字符串 (基础配置使用)
		String echostr = request.getParameter("echostr");
        // 验证是否是微信的请求
        if(WxSignUtils.checkSignature(signature, timestamp, nonce)){
            // 校验是否接入了微信
            if (false) {
                // TODO 处理消息和事件
            } else {
                // 第一次接入微信,基础配置时返回
                return echostr;
            }
        }
        return null;
    }
}
