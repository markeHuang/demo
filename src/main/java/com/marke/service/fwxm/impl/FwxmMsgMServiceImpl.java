package com.marke.service.fwxm.impl;

import com.marke.entity.vo.WxArticleVo;
import com.marke.entity.vo.WxMsgVo;
import com.marke.entity.vo.WxPicAndTextMsgVo;
import com.marke.service.fwxm.FwxmMsgMService;
import com.marke.utils.StringUtils;
import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * 回复文本信息
     */
    @Override
    public String processTextMsg(Map<String, String> map, String reqContent, Boolean isBindWx) {
        // 第一步：按照回复文本信息构造需要的参数
        WxMsgVo wxMsgVo = new WxMsgVo();
        // 发送和接收信息“User”刚好相反
        wxMsgVo.setToUserName(map.get("FromUserName"));
        wxMsgVo.setFromUserName(map.get("ToUserName"));
        // 消息创建时间 （整型）
        wxMsgVo.setCreateTime(System.currentTimeMillis());
        // 文本类型消息
        wxMsgVo.setMsgType("text");
        // 绑定微信
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
            // 正常消息请求
            if ("00".equals(reqContent)) {
                wxMsgVo.setContent("欢迎关注我的公众号！");
            } else {
                wxMsgVo.setContent("暂时未开通此项服务，敬请等待！");
            }
        }

        // 第二步，将构造的信息转化为微信识别的xml格式
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
//        return replyText(map, reqContent, false);
        return "";
    }
}
