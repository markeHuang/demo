package com.marke.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 模板信息表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FspaNtbM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 文件名称(下载文件名称)
     */
    @TableField("FILE_NAME")
    private String fileName;

    /**
     * 文件类型/后缀名
     */
    @TableField("FILE_TYPE")
    private String fileType;

    /**
     * 文件简称(实际模板名称)
     */
    @TableField("FILE_SIM_NAME")
    private String fileSimName;

    /**
     * 适用企业类型(多种企业类型用英文符号“,”隔开。)
     */
    @TableField("SUIT_ORG_TYPE")
    private String suitOrgType;

    /**
     * 文件用途[1-模板文件]
     */
    @TableField("FILE_PURPOSE")
    private String filePurpose;

    /**
     * 删除标记[是=1/否=0(Default)]
     */
    @TableField("DEL_FLAG")
    @TableLogic
    private String delFlag;


}
