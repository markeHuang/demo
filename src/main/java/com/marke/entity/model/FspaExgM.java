package com.marke.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FspaExgM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 参数类别[参考SMME_WEB_INITIALIZE.xls说明文件]
     */
    @TableField("PARM_TYPE")
    private String parmType;

    /**
     * 参数代号
     */
    @TableField("PARM_NAME")
    private String parmName;

    /**
     * 参数值
     */
    @TableField("PARM_VALUE")
    private String parmValue;

    /**
     * 参数说明
     */
    @TableField("PARM_DESC")
    private String parmDesc;

    /**
     * 父级代号
     */
    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 父级的参数类别
     */
    @TableField("PARENT_TYPE")
    private String parentType;

    /**
     * 参数值标记[真实值=1/多语言代号=2]
     */
    @TableField("PARM_FLAG")
    private String parmFlag;


}
