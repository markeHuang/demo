package com.marke.api.controller.wx;

import com.marke.config.SysConfiguration;
import com.marke.constant.GlobalConstants;
import com.marke.constant.SysConfigConstants;
import com.marke.entity.model.FipaSysM;
import com.marke.service.FipaSysMService;
import com.marke.utils.WxSignUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @Resource(type = SysConfiguration.class)
    private SysConfiguration sysConfiguration;

    @Resource(type = FipaSysMService.class)
    private FipaSysMService fipaSysMService;

    @Resource(type = WxSignUtils.class)
    private WxSignUtils wxSignUtils;

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
        if(wxSignUtils.checkSignature(signature, timestamp, nonce)){
            // 校验是否接入了微信
            if (GlobalConstants.Flag.TRUE.equals(sysConfiguration.getPWxJoin())) {
                // TODO 处理消息和事件
            } else {
                // 更新微信接入值
                FipaSysM fipaSysM = new FipaSysM();
                fipaSysM.setParamValue(GlobalConstants.Flag.TRUE);
                fipaSysMService.updateFipaSysMByParamName(fipaSysM, SysConfigConstants.P_WX_JOIN);
                // 刷新缓存
                sysConfiguration.refresh();
                // 第一次接入微信,基础配置时返回
                return echostr;
            }
        }
        return null;
    }
}
