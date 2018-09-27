package com.marke.api.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 标准请求实体类 .<br>
 *
 * @author andy.sher
 * @date 2018/7/16 15:21
 */
@Getter
@Setter
@ToString
public class ReqEntity implements Serializable {

    private static final long serialVersionUID = -3439039643191796038L;

    private String client;

    private String data;

    private Integer pageNum;

    private Integer pageSize;

}
