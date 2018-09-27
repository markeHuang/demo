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
 * 银行信息表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FipaBchM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 银行网点代号
     */
    @TableField("BANK_ID")
    private String bankId;

    /**
     * 银行网点名称
     */
    @TableField("BANK_NAME")
    private String bankName;

    /**
     * 网点级别[1=总行(行政)/2=总行(营业)/3=分(支)行]
     */
    @TableField("BANK_LEVEL")
    private String bankLevel;

    /**
     * 上级行代号
     */
    @TableField("PARENT_BANK_ID")
    private String parentBankId;

    /**
     * 所属银行
     */
    @TableField("BELONG_BANK_ID")
    private String belongBankId;

    /**
     * 银行大额行号
     */
    @TableField("CNAPS_CODE")
    private String cnapsCode;

    /**
     * 网点地址
     */
    @TableField("BANK_ADDR")
    private String bankAddr;

    /**
     * 网点所在地区
     */
    @TableField("BANK_AREA_CODE")
    private String bankAreaCode;

    /**
     * 图标名称
     */
    @TableField("BANK_ICON")
    private String bankIcon;

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
