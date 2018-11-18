package com.marke.api.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.marke.config.SysConfiguration;
import com.marke.constant.GlobalConstants;
import com.marke.constant.SysConfigConstants;
import com.marke.constant.WxConstants;
import com.marke.entity.model.FipaSysM;
import com.marke.remote.client.WxHttpsClient;
import com.marke.service.fipa.FipaSysMService;
import com.marke.service.fwxm.FwxmMsgMService;
import com.marke.service.fwxm.FwxmSatMService;
import com.marke.utils.Dom4jUtils;
import com.marke.utils.StringUtils;
import com.marke.utils.WxUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 微信服务模块
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

    @Resource(type = FwxmMsgMService.class)
    private FwxmMsgMService fwxmMsgMService;

    @Resource(type = WxHttpsClient.class)
    private WxHttpsClient wxHttpsClient;

    @Resource(type = FwxmSatMService.class)
    private FwxmSatMService fwxmSatMService;

    /**
     * 接收微信消息和事件
     *
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/9/26 0026 下午 4:29
     */
    @RequestMapping(value = "/doWxMsgOrEvent")
    public String doWxMsgOrEvent(HttpServletRequest request) {
        // 未开启直接返回空
        if (GlobalConstants.Flag.FALSE.equals(sysConfiguration.getPWxOpen())) {
            return null;
        }
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        //  随机字符串 (基础配置使用)
		String echostr = request.getParameter("echostr");
        // 与接口配置信息中的Token要一致
        String token = sysConfiguration.getPWxToken();
        // 验证是否是微信的请求
        if (WxUtils.checkSignature(signature, timestamp, nonce, token)) {
            // 校验是否接入了微信
            if (GlobalConstants.Flag.TRUE.equals(sysConfiguration.getPWxJoin())) {
                return this.processMsgOrEvent(request);
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
     * 处理消息和事件
     *
     * @param request
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/10/8 0008 下午 5:25
     */
    private String processMsgOrEvent(@NotNull HttpServletRequest request) {
        // 返回消息
        String result = StringUtils.EMPTY;

        // 解析微信消息，记录XML解析处理的数据进行存储：key是ToUserName，value是<![CDATA[toUser]]>....
        Map<String, String> map = Dom4jUtils.parseRequst(request);

        // 消息类型
        String msgType = map.get("MsgType");
        // 接收消息
        String reqContent = StringUtils.EMPTY;
        // 文本消息
        if (WxConstants.MsgType.TEXT.equals(msgType)) {
            reqContent = map.get("Content");
            result = fwxmMsgMService.processTextMsg(map, reqContent, false);
        }
        // 图片消息
        else if (WxConstants.MsgType.IMAGE.equals(msgType)) {
            reqContent = "";
            return null;
        }
        // 声音消息
        else if (WxConstants.MsgType.VOICE.equals(msgType)) {
            reqContent = "";
            return null;
        }
        // 视频消息
        else if (WxConstants.MsgType.VIDEO.equals(msgType)) {
            reqContent = "";
            return null;
        }
        // 地理位置
        else if (WxConstants.MsgType.LOCATION.equals(msgType)) {
            reqContent = "";
            return null;
        }
        // 事件信息
        else if (WxConstants.MsgType.EVENT.equals(msgType)) {
            return this.processEvent(map, reqContent);
        }

        return result;
    }

    /**
     * 处理事件
     *
     * @param map
     * @param reqContent
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/10/8 0008 下午 5:31
     */
    private String processEvent(@NotNull Map<String, String> map, String reqContent) {
        String result = StringUtils.EMPTY;
        String eventType = map.get("Event");
        String eventKey = map.get("EventKey");
        // 订阅
        if (WxConstants.EventType.SUBSCRIBE.equals(eventType)) {
            // 判断用户关注是否通过PC端扫描二维码
            if (StringUtils.isBlank(eventKey)) {
                // 用户关注时获取用户数据
                reqContent = "00";
                result = fwxmMsgMService.processTextMsg(map, reqContent, false);
            } else {
                // 获取userid
                String userid;
                // 判断是否已经关注关注
                if (eventKey.contains(WxConstants.Constans.QRSCENE)) {
                    // 第一次关注并绑定账号
                    int index = eventKey.indexOf(GlobalConstants.Symbol.UNDERLINE);
                    // 获取userid
                    userid = eventKey.substring(index + 1);
                } else {
                    // 获取userid
                    userid = eventKey;
                }
                map.put("userid", userid);
                // 绑定账号并发送消息
                result = fwxmMsgMService.processTextMsg(map, reqContent, true);
            }
        }
        // 已经订阅，但是重新绑定
        else if (WxConstants.EventType.SCAN.equals(eventType)) {
            // 获取userid
            String userid;
            // 判断是否已经关注关注
            if (eventKey.contains(WxConstants.Constans.QRSCENE)) {
                // 第一次关注并绑定账号
                int index = eventKey.indexOf(GlobalConstants.Symbol.UNDERLINE);
                // 获取userid
                userid = eventKey.substring(index, eventKey.length() - 1);
            } else {
                // 获取userid
                userid = eventKey;
            }
            map.put("userid", userid);
            // 绑定账号并发送消息
            result = fwxmMsgMService.processTextMsg(map, reqContent, true);
        }
        // 取消订阅
        else if (WxConstants.EventType.UNSUBSCRIBE.equals(eventType)) {
            return null;
        }
        // 点击菜单推送消息
        else if (WxConstants.EventType.CLICK.equals(eventType)) {
//            if ("V1001_TODAY_MUSIC".equals(eventKey)) {
//                    result = this.replyClickText(map, eventKey);
//            }
        }
        return result;
    }

    /**
     * 获取微信临时二维码
     *
     * @param
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/17 13:45
     */
    @GetMapping("/getWxTemporaryCode")
    @RequiresAuthentication
    public String getWxTemporaryCode() {
        // 二维码ticket
        String ticket = StringUtils.EMPTY;
        // 用户ID
        String userid = "";
        // 获取临时二维码的参数
        String param = "{\"expire_seconds\": 86400, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\":" + userid + "}}}";
        // 获取二维码的URL
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s";
        // 获取token
        String token = fwxmSatMService.getAccessToken();
        // 替换token
        requestUrl = String.format(requestUrl, token);
        JSONObject jsonResult = wxHttpsClient.httpsRequest(requestUrl, "POST", param);
        if (jsonResult != null) {
            ticket = jsonResult.getString("ticket");
        }
        // 二维码地址ticketUrl
        String ticketUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";
        ticketUrl= String.format(ticketUrl, ticket);
        return ticketUrl;
    }

}
