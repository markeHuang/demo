/**
 * 创建于: 2017年10月30日 上午10:10:57<br>
 * 所属项目:CSPS(保理公司保理系统)
 * 文件名称:WxMsgVo.java
 * 作者:jiangming.huang
 * 版权信息: 版权所有 © 2001-2017 天逸财金科技服务(武汉)有限公司
 */
package com.marke.entity.vo;

import java.io.Serializable;

/**
 * 类功能描述：微信消息(普通文字消息)
 * WxMsgVo.java
 *
 * @author marke.huang
 * @version 0.1.0
 * @history 2017年10月30日 jiangming.huang 创建WxMsgVo.java
 */
public class WxMsgVo implements Serializable {
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
     * 消息类型（文本消息为 text ）
     */
    private String MsgType;

    /**
     * 消息类型（文本消息内容）
     */
    private String Content;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
