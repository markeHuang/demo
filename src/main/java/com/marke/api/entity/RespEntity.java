package com.marke.api.entity;

import com.alibaba.fastjson.JSONObject;
import com.marke.api.enums.RespCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 标准响应实体类
 *
 * @author marke.huang
 * @date 2018/11/17 13:54
 */
@Getter
@Setter
@ToString
public class RespEntity implements Serializable {

    private static final long serialVersionUID = 9120481866981475700L;

    private Integer code;

    private String msg;

    private String data;

    private Integer totalCount;

    public RespEntity() {
    }

    public RespEntity(RespCodeEnum respCodeEnum) {
        this.code = respCodeEnum.getCode();
        this.msg = respCodeEnum.getMsg();
    }

    public RespEntity(RespCodeEnum respCodeEnum, String data) {
        this(respCodeEnum);
        this.data = data;
    }

    public String toJSONString() {
        return JSONObject.toJSONString(this);
    }

    /**
     * 请求成功 .<br>
     *
     * @param
     * @return com.vteam.sme.api.entity.RespEntity 响应对象
     * @author andy.sher
     * @date 2018/7/31 10:18
     */
    public static RespEntity ok() {
        return new RespEntity(RespCodeEnum.SUCCESS);
    }

    /**
     * 请求成功 .<br>
     *
     * @param dataString 响应JSON数据字符串
     * @return com.vteam.sme.api.entity.RespEntity 响应对象
     * @author andy.sher
     * @date 2018/7/31 10:19
     */
    public static RespEntity ok(@NotNull @NotBlank String dataString) {
        return new RespEntity(RespCodeEnum.SUCCESS, dataString);
    }

    /**
     * 请求成功 .<br>
     *
     * @param data 响应数据
     * @return com.vteam.sme.api.entity.RespEntity 响应对象
     * @author andy.sher
     * @date 2018/7/31 10:19
     */
    public static RespEntity ok(@NotNull JSONObject data) {
        return new RespEntity(RespCodeEnum.SUCCESS, data.toJSONString());
    }

    /**
     * JWT过期 .<br>
     *
     * @param
     * @return com.vteam.sme.api.entity.RespEntity 响应对象
     * @author andy.sher
     * @date 2018/7/31 10:19
     */
    public static RespEntity expired() {
        return new RespEntity(RespCodeEnum.TOKEN_EXPIRED);
    }

    /**
     * JWT无效 .<br>
     *
     * @param
     * @return com.vteam.sme.api.entity.RespEntity 响应对象
     * @author andy.sher
     * @date 2018/7/31 10:19
     */
    public static RespEntity invalid() {
        return new RespEntity(RespCodeEnum.TOKEN_INVALID);
    }

    /**
     * 授权失败 .
     *
     * @param
     * @return com.vteam.sme.api.entity.RespEntity
     * @author andy.sher
     * @date 2018/8/15 10:59
     */
    public static RespEntity unauthorized() {
        RespEntity respEntity = new RespEntity(RespCodeEnum.UNAUTHORIZED);
        respEntity.setMsg("授权失败");
        return respEntity;
    }

    /**
     * 认证失败 .
     *
     * @param
     * @return com.vteam.sme.api.entity.RespEntity
     * @author andy.sher
     * @date 2018/8/15 10:59
     */
    public static RespEntity unauthenticated() {
        RespEntity respEntity = new RespEntity(RespCodeEnum.UNAUTHORIZED);
        respEntity.setMsg("认证失败");
        return respEntity;
    }

}
