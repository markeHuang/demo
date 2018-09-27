package com.marke.entity.model;

import java.math.BigDecimal;
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
 * 货币别信息表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FipaCcyM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 币别代号
     */
    @TableField("CCYID")
    private String ccyid;

    /**
     * 币别描述
     */
    @TableField("CCYDESC")
    private String ccydesc;

    /**
     * 精确至小数位数
     */
    @TableField("DECIMAL_POSI")
    private Integer decimalPosi;

    /**
     * 编辑格式
     */
    @TableField("CCY_EDIT_FMT")
    private String ccyEditFmt;

    /**
     * 显示格式
     */
    @TableField("CCY_DISP_FMT")
    private String ccyDispFmt;

    /**
     * 计息基础日
     */
    @TableField("BASE_DAY")
    private Integer baseDay;

    /**
     * 币别利率换算设定1
     */
    @TableField("EXGRATE_01")
    private BigDecimal exgrate01;

    /**
     * 币别利率换算设定2
     */
    @TableField("EXGRATE_02")
    private BigDecimal exgrate02;

    /**
     * 币别利率换算设定3
     */
    @TableField("EXGRATE_03")
    private BigDecimal exgrate03;

    /**
     * 币别利率换算设定4
     */
    @TableField("EXGRATE_04")
    private BigDecimal exgrate04;

    /**
     * 币别利率换算设定5
     */
    @TableField("EXGRATE_05")
    private BigDecimal exgrate05;

    /**
     * 币别利率换算设定6
     */
    @TableField("EXGRATE_06")
    private BigDecimal exgrate06;

    /**
     * 币别利率换算设定7
     */
    @TableField("EXGRATE_07")
    private BigDecimal exgrate07;

    /**
     * 币别利率换算设定8
     */
    @TableField("EXGRATE_08")
    private BigDecimal exgrate08;

    /**
     * 币别利率换算设定9
     */
    @TableField("EXGRATE_09")
    private BigDecimal exgrate09;

    /**
     * 币别利率换算设定10
     */
    @TableField("EXGRATE_10")
    private BigDecimal exgrate10;

    /**
     * 币别利率换算设定11
     */
    @TableField("EXGRATE_11")
    private BigDecimal exgrate11;

    /**
     * 币别利率换算设定12
     */
    @TableField("EXGRATE_12")
    private BigDecimal exgrate12;

    /**
     * 当前主机币别
     */
    @TableField("HOST_CCYID")
    private String hostCcyid;

    /**
     * 当前营业日
     */
    @TableField("BUSSDATE")
    private LocalDateTime bussdate;

    /**
     * 买入上浮百分比(0～1之间)
     */
    @TableField("BUP_PCNT")
    private BigDecimal bupPcnt;

    /**
     * 卖出下浮百分比(0～1之间)
     */
    @TableField("SDW_PCNT")
    private BigDecimal sdwPcnt;

    /**
     * 货币单价
     */
    @TableField("UNIT_PRICE")
    private Integer unitPrice;

    /**
     * EDI币别代号
     */
    @TableField("EDI_CCYID")
    private String ediCcyid;

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
