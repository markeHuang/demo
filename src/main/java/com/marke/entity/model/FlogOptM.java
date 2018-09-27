package com.marke.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FlogOptM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 功能代号(对应菜单树的代号) (登陆为:login,登出为:logout)
     */
    @TableField("FUN_ID")
    private String funId;

    /**
     * 功能描述(对应菜单树的描述)
     */
    @TableField("FUN_DESC")
    private String funDesc;

    /**
     * 操作代号[login(登录)、logout(登出)、ENT(进入功能)、SMT(提交)、NEW、MOD、DEL/……]
     */
    @TableField(value = "EDTID", fill = FieldFill.INSERT_UPDATE)
    private String edtid;

    /**
     * 调用XML地址
     */
    @TableField("XML_PATH")
    private String xmlPath;

    /**
     * 调用后台SERVICE名
     */
    @TableField("SERVICE_NAME")
    private String serviceName;

    /**
     * 调用后台FUNCTION名
     */
    @TableField("FUNCTION_NAME")
    private String functionName;

    /**
     * 提交后台的数据(截取前1000个字符)
     */
    @TableField("PARAMETERS")
    private String parameters;

    /**
     * 操作者IP
     */
    @TableField("OPERATOR_IP")
    private String operatorIp;

    /**
     * 操作者地址
     */
    @TableField("OPERATOR_ADDRESS")
    private String operatorAddress;

    /**
     * 操作者
     */
    @TableField("OPERATOR")
    private String operator;

    /**
     * 操作者机构流水号
     */
    @TableField("OPERATOR_ORG_REFCODE")
    private Integer operatorOrgRefcode;

    /**
     * 操作时间
     */
    @TableField("OPERATE_DATE")
    private LocalDateTime operateDate;


}
