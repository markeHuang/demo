package com.marke.api.controller.wx;

import com.marke.config.SysConfiguration;
import com.marke.constant.GlobalConstants;
import com.marke.constant.SysConfigConstants;
import com.marke.entity.model.FipaSysM;
import com.marke.service.FipaSysMService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
        if (this.checkSignature(signature, timestamp, nonce)) {
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

    /**
     * 校验请求来源为微信
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return boolean
     * @author jiangming.huang
     * @date 2018/9/26 0026 下午 4:33
     */
    private boolean checkSignature(String signature, String timestamp, String nonce) {
        // 与接口配置信息中的Token要一致
        String token = sysConfiguration.getPWxToken();
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
