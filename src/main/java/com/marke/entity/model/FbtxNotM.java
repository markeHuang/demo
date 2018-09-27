package com.marke.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 平台消息提醒表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FbtxNotM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 消息发起用户类型[1=系统/2=企业/3=用户]
     */
    @TableField("PUSH_TYPE")
    private String pushType;

    /**
     * 消息发起企业(机构)流水号
     */
    @TableField("PUSH_ORG_REFCODE")
    private Integer pushOrgRefcode;

    /**
     * 消息接收用户id
     */
    @TableField("RECEIVE_USERID")
    private String receiveUserid;

    /**
     * 消息接收企业(机构)流水号
     */
    @TableField("RECEIVE_ORG_REFCODE")
    private Integer receiveOrgRefcode;

    /**
     * 消息编号
     */
    @TableField("NOTICE_CODE")
    private String noticeCode;

    /**
     * 消息标题
     */
    @TableField("NOTICE_TITLE")
    private String noticeTitle;

    /**
     * 消息内容
     */
    @TableField("NOTICE_CONTENT")
    private String noticeContent;

    /**
     * 消息带链接内容
     */
    @TableField("NOTICE_CONTENT_HREF")
    private String noticeContentHref;

    /**
     * 消息状态(0=未读/1=已读)
     */
    @TableField("NOTICE_FLAG")
    private String noticeFlag;

    /**
     * 读取时间
     */
    @TableField("READ_TIME")
    private LocalDateTime readTime;

    /**
     * 是否在首页显示(0=否/1=是)
     */
    @TableField("SHOW_HOME")
    private String showHome;

    /**
     * 资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]
     */
    @TableField(value = "DATA_STATUS", fill = FieldFill.INSERT)
    private String dataStatus;

    /**
     * 审批流PK
     */
    @TableField("ENTITY_ID")
    private String entityId;

    /**
     * 删除标记[是=1/否=0(Default)]
     */
    @TableField("DEL_FLAG")
    @TableLogic
    private String delFlag;

    /**
     * 创建者
     */
    @TableField(value = "CREATE_USER", fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 创建者代理人
     */
    @TableField("CREATE_AGENT_USER")
    private String createAgentUser;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_DATE", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 操作类型
     */
    @TableField(value = "EDTID", fill = FieldFill.INSERT_UPDATE)
    private String edtid;

    /**
     * 操作者
     */
    @TableField(value = "LAST_MOD_USER", fill = FieldFill.INSERT_UPDATE)
    private String lastModUser;

    /**
     * 操作代理人
     */
    @TableField("AGENT_USER")
    private String agentUser;

    /**
     * 操作时间
     */
    @TableField(value = "LAST_MOD_DATE", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastModDate;


}
