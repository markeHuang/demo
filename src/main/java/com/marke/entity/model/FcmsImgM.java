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
 * 图片表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FcmsImgM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId("REFCODE")
    private Integer refcode;

    /**
     * 栏目代码
     */
    @TableField("CATEGORY_CODE")
    private String categoryCode;

    /**
     * 图片名称
     */
    @TableField("IMAGE_NAME")
    private String imageName;

    /**
     * 起始有效日期
     */
    @TableField("START_DATE")
    private LocalDateTime startDate;

    /**
     * 截止有效日期
     */
    @TableField("END_DATE")
    private LocalDateTime endDate;

    /**
     * 图片排序
     */
    @TableField("IMAGE_RANK")
    private Integer imageRank;

    /**
     * 图片链接地址
     */
    @TableField("IMAGE_URL")
    private String imageUrl;

    /**
     * 图片链接打开方式[1=_blank/2=_self]
     */
    @TableField("IMAGE_URL_OPEN_TYPE")
    private String imageUrlOpenType;

    /**
     * 图片UUID
     */
    @TableField("IMAGE_UUID")
    private String imageUuid;

    /**
     * 是否启用[0=禁用/1=启用]
     */
    @TableField("USE_FLAG")
    private String useFlag;

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
