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
 * 地区信息表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FipaAreM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 地区级别[1=省/2=市/3=区]
     */
    @TableField("AREA_LEVEL")
    private String areaLevel;

    /**
     * 区域类型代码[1=华北/2=东北/3=华东/4=华中/5=华南/6=西南/7=西北/8=台港澳]
     */
    @TableField("AREA_TYPE_CODE")
    private String areaTypeCode;

    /**
     * 行政区划代码
     */
    @TableField("AREA_CODE")
    private String areaCode;

    /**
     * 省代码
     */
    @TableField("PROVINCE_CODE")
    private String provinceCode;

    /**
     * 行政区域
     */
    @TableField("AREA_DESC")
    private String areaDesc;

    /**
     * 省名称
     */
    @TableField("PROVINCE_NAME")
    private String provinceName;

    /**
     * 市名称
     */
    @TableField("CITY_NAME")
    private String cityName;

    /**
     * 县名称
     */
    @TableField("COUNTY_NAME")
    private String countyName;

    /**
     * 乡镇名称
     */
    @TableField("TOWN_NAME")
    private String townName;

    /**
     * 邮编
     */
    @TableField("POST_CODE")
    private String postCode;

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
