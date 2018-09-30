package com.marke.service.fwxm.impl;

import com.marke.entity.vo.WxArticleVo;
import com.marke.entity.vo.WxMsgVo;
import com.marke.entity.vo.WxPicAndTextMsgVo;
import com.marke.service.fwxm.FwxmMsgMService;
import com.marke.utils.StringUtils;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信消息服务
 *
 * @author jiangming.huang
 * @date 2018/9/30 0030 下午 2:20
 */
@Service
public class FwxmMsgMServiceImpl implements FwxmMsgMService {

    /**
     * 消息处理
     */
    @Override
    public String processMsg(HttpServletRequest request) {
        // 解析微信消息
        Map<String, String> map = this.parseXml(request);

        // 返回消息
        String result = StringUtils.EMPTY;
        // 消息类型
        String msgType = map.get("MsgType");
        // 接收消息
        String reqContent = StringUtils.EMPTY;
        //文本消息
        if ("text".equals(msgType)) {
            reqContent = map.get("Content");
            result = this.replyText(map, reqContent, false);
        }
        //图片消息
        else if ("image".equals(msgType)) {
            reqContent = "";
            return null;
        }
        //声音消息
        else if ("voice".equals(msgType)) {
            reqContent = "";
            return null;
        }
        //视频消息
        else if ("video".equals(msgType)) {
            reqContent = "";
            return null;
        }
        //地理位置
        else if ("location".equals(msgType)) {
            reqContent = "";
            return null;
        }
        //事件类型
        else if ("event".equals(msgType)) {
            String eventType = map.get("Event");
            String eventKey = map.get("EventKey");
            //订阅
            if ("subscribe".equals(eventType)) {
                // 判断用户关注是否通过推广的二维码
                if (StringUtils.isBlank(eventKey)) {
                    // 用户关注时获取用户数据
                    reqContent = "00";
                    result = this.replyText(map, reqContent, false);
                } else {
                    // 获取userid
                    String userid = StringUtils.EMPTY;
                    // 判断是否已经关注关注
                    if (eventKey.contains("qrscene")) {
                        // 第一次关注并绑定账号
                        int index = eventKey.indexOf("_");
                        // 获取userid
                        userid = eventKey.substring(index + 1, eventKey.length());
                    } else {
                        // 获取userid
                        userid = eventKey;
                    }
                    map.put("userid", userid);
                    // 绑定账号并发送消息
                    result = this.replyText(map, reqContent, true);
                }
            }
            // 已经订阅，但是重新绑定
            if ("SCAN".equals(eventType)) {
                // 获取userid
                String userid = StringUtils.EMPTY;
                // 判断是否已经关注关注
                if (eventKey.contains("qrscene")) {
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
                result = this.replyText(map, reqContent, true);
            }
            //取消订阅
            else if (eventType.equals("unsubscribe")) {
                return null;
            }
            //点击菜单推送消息
            else if ("CLICK".equals(eventType)) {
                if ("V1001_TODAY_MUSIC".equals(eventKey)) {
                    result = this.replyClickText(map, eventKey);
                }
            }
        }
        return result;
    }

    /**
     * 解析微信消息
     *
     * @param request
     * @return java.util.Map<java.lang.String , java.lang.String>
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

    /**
     * 回复文本信息
     *
     * @param map
     * @param reqContent
     * @param isBindWx   是否绑定微信
     * @return
     */
    private String replyText(Map<String, String> map, String reqContent, Boolean isBindWx) {
        // 第一步：按照回复文本信息构造需要的参数
        WxMsgVo wxMsgVo = new WxMsgVo();
        // 发送和接收信息“User”刚好相反
        wxMsgVo.setToUserName(map.get("FromUserName"));
        wxMsgVo.setFromUserName(map.get("ToUserName"));
        // 消息创建时间 （整型）
        wxMsgVo.setCreateTime(System.currentTimeMillis());
        // 文本类型消息
        wxMsgVo.setMsgType("text");
        if (isBindWx) {
            // 获取userid
            String userid = map.get("userid");
            // 获取openid
            String openid = map.get("FromUserName");
            if (StringUtils.isBlank(userid) || StringUtils.isBlank(openid)) {
                wxMsgVo.setContent("很遗憾，未成功绑定微信账号，请重试！");
            } else {
                // 绑定账号
//                String text = sipaBurMService.bindWxOpenId(userid, openid);
//                wxMsgVo.setContent(text);
            }
        } else {
            if ("00".equals(reqContent)) {
                wxMsgVo.setContent("欢迎关注我的公众号！");
            } else {
                wxMsgVo.setContent("暂时未开通此项服务，敬请等待！");
            }
        }

        // // 第二步，将构造的信息转化为微信识别的xml格式
        XStream xStream = new XStream();
        xStream.alias("xml", wxMsgVo.getClass());
        String textMsg2Xml = xStream.toXML(wxMsgVo);
        return textMsg2Xml;
    }

    /**
     * 回复图文消息
     *
     * @param map
     * @param reqContent
     * @return
     */
    public String replyPicAndText(Map<String, String> map, String reqContent) {
        // 第一步：按照回复图文信息构造需要的参数
        List<WxArticleVo> wxArticleVoList = new ArrayList<WxArticleVo>();
        WxArticleVo acArticleVo = new WxArticleVo();
        acArticleVo.setTitle("我是图片标题");
        // 该地址是点击图片跳转后
        acArticleVo.setUrl("www.baidu.com");
        // 该地址是一个有效的图片地址
        acArticleVo.setPicUrl("http://b.hiphotos.baidu.com/image/pic/item/08f790529822720ea5d058ba7ccb0a46f21fab50.jpg");
        acArticleVo.setDescription("我是图片的描述");
        wxArticleVoList.add(acArticleVo);

        // 微信消息(图文消息)
        WxPicAndTextMsgVo picAndTextMsg = new WxPicAndTextMsgVo();
        // 发送和接收信息“User”刚好相反
        picAndTextMsg.setToUserName(map.get("FromUserName"));
        picAndTextMsg.setFromUserName(map.get("ToUserName"));
        // 消息创建时间 （整型）
        picAndTextMsg.setCreateTime(System.currentTimeMillis());
        // 图文类型消息
        picAndTextMsg.setMsgType("news");
        // 图文消息个数（限制10个）
        picAndTextMsg.setArticleCount(1);
        picAndTextMsg.setArticles(wxArticleVoList);
        // 第二步，将构造的信息转化为微信识别的xml格式
        XStream xStream = new XStream();
        xStream.alias("xml", picAndTextMsg.getClass());
        xStream.alias("item", acArticleVo.getClass());
        String picAndTextMsg2Xml = xStream.toXML(picAndTextMsg);
        return picAndTextMsg2Xml;
    }

    /**
     * 回复点击菜单推送消息
     *
     * @param map
     * @param reqContent
     * @return java.lang.String
     * @author jiangming.huang
     * @date 2018/9/30 0030 下午 2:49
     */
    private String replyClickText(Map<String, String> map, String reqContent) {
        return replyText(map, reqContent, false);
    }
}
