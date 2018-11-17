package com.marke.api.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 标准请求实体类
 *
 * @author marke.huang
 * @date 2018/11/17 13:54
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
