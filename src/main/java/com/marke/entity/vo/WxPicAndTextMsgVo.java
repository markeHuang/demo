package com.marke.entity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 微信消息(图文消息)
 *
 * @author jiangming.huang
 * @date 2018/9/30 0030 下午 2:43
 */
@Getter
@Setter
@ToString
public class WxPicAndTextMsgVo implements Serializable {
    private static final long serialVersionUID = -9160293658130359658L;
    /**
     * 开发者微信号
     */
    private String ToUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;

    /**
     * 消息创建时间 （整型）
     */
    private long CreateTime;

    /**
     * 消息类型（文本消息为 news ）
     */
    private String MsgType;

    /**
     * 消息类型（文本消息内容）
     */
    private String Content;

    /**
     * 图文消息个数（限制10个）
     */
    private int ArticleCount;

    /**
     * 图文消息内部Article
     */
    private List<WxArticleVo> Articles;

}
