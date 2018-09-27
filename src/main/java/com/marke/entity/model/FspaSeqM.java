package com.marke.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据库序列表
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FspaSeqM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序列名
     */
    @TableId("NAME")
    private String name;

    /**
     * 当前值
     */
    @TableField("CURRENT_VALUE")
    private Integer currentValue;


}
