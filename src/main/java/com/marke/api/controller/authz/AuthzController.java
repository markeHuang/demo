package com.marke.api.controller.authz;

import com.alibaba.fastjson.JSONObject;
import com.marke.api.RequestStore;
import com.marke.api.entity.ReqEntity;
import com.marke.api.entity.RespEntity;
import com.marke.constant.FieldContants;
import com.marke.constant.GlobalConstants;
import com.marke.entity.vo.SipaBurMVo;
import com.marke.plugin.cache.TimeoutMapCache;
import com.marke.service.sipa.SipaBurMService;
import com.marke.utils.JwtUtils;
import com.marke.utils.SysAssert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 安控服务模块
 *
 * @author marke.huang
 * @date 2018/11/17 18:54
 */
@RestController
@RequestMapping(value = "/authz")
public class AuthzController {

    @Resource(type = TimeoutMapCache.class)
    private TimeoutMapCache timeoutMapCache;

    @Resource(type = SipaBurMService.class)
    private SipaBurMService sipaBurMService;

    /**
     * 登录
     *
     * @param reqEntity
     * @return com.marke.api.entity.RespEntity
     * @author marke.huang
     * @date 2018/11/17 19:17
     */
    @PostMapping("/doLogin")
    public RespEntity doLogin(ReqEntity reqEntity) {
        SipaBurMVo loginUser = JSONObject.parseObject(reqEntity.getData(), SipaBurMVo.class);
        String key = loginUser.getUuid();

        SysAssert.notBlank(key, "验证码ID为空");
        // 真实验证码
        String realCode = null != timeoutMapCache.get(key) ? timeoutMapCache.get(key).toString() : null;
        String inCode = loginUser.getVerificationCode();

        SysAssert.notBlank(inCode, "验证码为空");
        SysAssert.notBlank(realCode, "验证码已超时");
        SysAssert.equalsIgnoreCase(inCode, realCode, "验证码错误");

        SysAssert.notNull(loginUser.getLoginid(), "用户名为空");
        SysAssert.notNull(loginUser.getPassword(), "密码为空");

        SipaBurMVo userInfo = sipaBurMService.getUserInfoByMobilephone(loginUser.getLoginid());
        if (null == userInfo) {
            userInfo = sipaBurMService.getUserInfoByUserid(loginUser.getLoginid());
        }

        SysAssert.notNull(userInfo, "用户不存在");
        SysAssert.eq(userInfo.getPassword(), loginUser.getPassword(), "用户名或密码错误");
        SysAssert.eq(userInfo.getSystemType(), FieldContants.SipaBurM.SYSTEM_TYPE_OPERATION, "请使用后台账号登录");
        SysAssert.ne(GlobalConstants.Flag.FALSE, userInfo.getUseFlag(), "您已被禁用，无法登录，请联系管理员");

        // 删除验证码
        timeoutMapCache.delete(key);

        // 记录用户登陆信息
        userInfo.setLastLoginDate(LocalDateTime.now());
        userInfo.setLastLoginAddress(RequestStore.getLocation());
        sipaBurMService.updateById(userInfo);

        JSONObject data = new JSONObject();
        data.put(GlobalConstants.Flag.TOKEN, JwtUtils.sign(userInfo.getPassword(), userInfo.getMobilephone(), userInfo.getUserid()));
        userInfo.setPassword(null);
        data.put("userInfo", userInfo);
        return RespEntity.ok(data);
    }
}
