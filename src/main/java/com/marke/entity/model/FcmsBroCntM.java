package com.marke.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 页面统计表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FcmsBroCntM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 浏览器标识
     */
    @TableField("USER_AGENT")
    private String userAgent;

    /**
     * 浏览器来源信息
     */
    @TableField("REFERER")
    private String referer;

    /**
     * 浏览器URL信息
     */
    @TableField("URL")
    private String url;

    /**
     * 操作系统
     */
    @TableField("OS")
    private String os;

    /**
     * 浏览器HREF信息
     */
    @TableField("HREF")
    private String href;

    /**
     * 浏览器类型
     */
    @TableField("BROWSER")
    private String browser;

    /**
     * 浏览器语言
     */
    @TableField("BROWSER_LANGUAGE")
    private String browserLanguage;

    /**
     * 功能模块
     */
    @TableField("FUNC_MODEL")
    private String funcModel;

    /**
     * IP地址
     */
    @TableField("IP")
    private String ip;

    /**
     * 访问实际值
     */
    @TableField("COUNT")
    private Integer count;

    /**
     * 访问模拟值
     */
    @TableField("COUNT_VIRTUAL")
    private Integer countVirtual;

    /**
     * 访问来源平台
     */
    @TableField("REFERER_PLATFORM")
    private String refererPlatform;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;


}
