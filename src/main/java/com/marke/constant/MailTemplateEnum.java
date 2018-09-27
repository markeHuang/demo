package com.marke.constant;

/**
 * 邮件模板
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:49
 */
public enum MailTemplateEnum {

    /**
     * 邮箱验证验证码
     */
    UCENTER_YXYZYZM("ucenter_yxyzyzm");

    MailTemplateEnum(String templateCode) {
        this.templateCode = templateCode;
    }

    private String templateCode;

    public String getTemplateCode() {
        return this.templateCode;
    }

}
