package com.marke.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * Excel数据导入配置表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CspaExcM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * Excel文档号
     */
    @TableField("EXID")
    private String exid;

    /**
     * Sheet号
     */
    @TableField("SHEET_ID")
    private String sheetId;

    /**
     * 字段名称
     */
    @TableField("EXNAME")
    private String exname;

    /**
     * 字段描述
     */
    @TableField("EXDESC")
    private String exdesc;

    /**
     * 匹配Excel描述
     */
    @TableField("MATCH_NAME")
    private String matchName;

    /**
     * 表名
     */
    @TableField("EXTABLE")
    private String extable;

    /**
     * 字段类型
     */
    @TableField("DATA_TYPE")
    private String dataType;

    /**
     * 字段长度
     */
    @TableField("DATA_LEN")
    private Integer dataLen;

    /**
     * 行号
     */
    @TableField("EXROW_ID")
    private Integer exrowId;

    /**
     * 列号
     */
    @TableField("EXCOL_ID")
    private Integer excolId;

    /**
     * 是否必输[0=否/1=是]
     */
    @TableField("IS_INPUT")
    private String isInput;

    /**
     * 是否循环[0=否/1=是]
     */
    @TableField("IS_CYCLE")
    private String isCycle;

    /**
     * 是否有效[0=否/1=是]
     */
    @TableField("IS_VALID")
    private String isValid;

    /**
     * 是否主键[0=否/1=是]
     */
    @TableField("IS_PK")
    private String isPk;

    /**
     * 是否显示[0=否/1=是]
     */
    @TableField("IS_SHOW")
    private String isShow;

    /**
     * 是否修改[0=否/1=是]
     */
    @TableField("IS_MODIFY")
    private String isModify;

    /**
     * 页面展示样式[0=文本标签/1=文本框/2=大文本框/3=下拉框]
     */
    @TableField("SHOW_STYLE")
    private String showStyle;

    /**
     * 循环方式[0=横向/1=纵向]
     */
    @TableField("EXDIRECT")
    private String exdirect;

    /**
     * 取值方式[0=行加一/1=列加一]
     */
    @TableField("GET_VALUE_STYLE")
    private String getValueStyle;


}
