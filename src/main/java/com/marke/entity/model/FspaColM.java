package com.marke.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 多语言描述表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FspaColM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 多语言ID
     */
    @TableField("COL_ID")
    private String colId;

    /**
     * 语言种类
     */
    @TableField("LANGUAGE_ID")
    private String languageId;

    /**
     * 描述
     */
    @TableField("COL_DESC")
    private String colDesc;


}
