package com.marke.entity.vo;

import com.marke.entity.model.SipaBurM;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户信息表扩展类
 *
 * @author marke.huang
 * @date 2018/11/17 19:21
 */
@Getter
@Setter
@ToString(callSuper = true)
public class SipaBurMVo extends SipaBurM {

    /**
     * 验证码id
     */
    private String uuid;

    /**
     * 验证码
     */
    private String verificationCode;

    /**
     * 登录用户名
     */
    private String loginid;
}
