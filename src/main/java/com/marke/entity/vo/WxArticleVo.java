package com.marke.entity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 微信图文信息构造VO
 *
 * @author marke.huang
 * @date 2018/9/30 0030 下午 2:41
 */
@Getter
@Setter
@ToString
public class WxArticleVo implements Serializable {
    private static final long serialVersionUID = 1919026435770065262L;

    /**
     * 图片标题
     */
    private String Title;

    /**
     * 图片描述
     */
    private String Description;

    /**
     * 图片地址
     */
    private String PicUrl;

    /**
     * 点击图片后跳转的页面Url
     */
    private String Url;

}
