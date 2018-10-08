package com.marke.api.controller.wx;

import com.marke.config.SysConfiguration;
import com.marke.constant.GlobalConstants;
import com.marke.constant.SysConfigConstants;
import com.marke.constant.WxConstants;
import com.marke.entity.model.FipaSysM;
import com.marke.service.fipa.FipaSysMService;
import com.marke.service.fwxm.FwxmMsgMService;
import com.marke.utils.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Resource(type = FwxmMsgMService.class)
    private FwxmMsgMService fwxmMsgMService;

    /**
     * 接收微信消息和事件
     *
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/9/26 0026 下午 4:29
     */
    @RequestMapping(value = "/doWxMsgOrEvent")
    public String doWxMsgOrEvent(HttpServletRequest request) {
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
     * 校验请求来源为微信
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return boolean
     * @author marke.huang
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

    /**
     * 处理消息和事件
     *
     * @param request
     * @return java.lang.String
     * @author jiangming.huang
     * @date 2018/10/8 0008 下午 5:25
     */
    private String processMsgOrEvent(HttpServletRequest request) {
        // 解析微信消息
        Map<String, String> map = this.parseXml(request);
        // 返回消息
        String result = StringUtils.EMPTY;
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
     * @author jiangming.huang
     * @date 2018/10/8 0008 下午 5:31
     */
    private String processEvent(Map<String, String> map, String reqContent) {
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
                int index = eventKey.indexOf("_");
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
     * 解析微信消息
     *
     * @param request
     * @return java.util.Map<java.lang.String   ,   java.lang.String>
     * @author marke.huang
     * @date 2018/9/30 0030 下午 2:28
     */
    private Map<String, String> parseXml(HttpServletRequest request) {
        // 记录XML解析处理的数据进行存储：key是ToUserName，value是<![CDATA[toUser]]>....
        Map<String, String> map = new LinkedHashMap<String, String>();
        try {
            // 根据请求request对象获取流对象
            final InputStream inputStream = request.getInputStream();

            /* DOM4J解析 */
            // 创建SAX解析构造器对象
            final SAXReader reader = new SAXReader();
            // 通过读取流的对象，获取文档对象
            final Document document = reader.read(inputStream);
            // 获取跟节点:<xml> 这个是就更节点
            final Element root = document.getRootElement();
            // 获取跟节点下的子节点
            final List<Element> elements = root.elements();
            // 遍历解析
            for (Element element : elements) {
                // 节点名称和节点的值
                map.put(element.getName(), element.getText());
            }

            // 关闭流
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

}
