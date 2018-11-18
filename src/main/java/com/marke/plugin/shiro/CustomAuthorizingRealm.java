package com.marke.plugin.shiro;

import com.marke.constant.GlobalConstants;
import com.marke.entity.model.SipaBtrM;
import com.marke.entity.model.SipaRolM;
import com.marke.entity.model.SipaRtfM;
import com.marke.entity.vo.SipaBurMVo;
import com.marke.service.cspa.CspaFunMService;
import com.marke.service.sipa.SipaBtrMService;
import com.marke.service.sipa.SipaBurMService;
import com.marke.service.sipa.SipaRolMService;
import com.marke.service.sipa.SipaRtfMService;
import com.marke.utils.JwtUtils;
import com.marke.utils.SysAssert;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义认证授权类
 *
 * @author marke.huang
 * @date 2018/11/17 20:18
 */
@Service
public class CustomAuthorizingRealm extends AuthorizingRealm {

    @Resource(type = SipaBurMService.class)
    private SipaBurMService sipaBurMService;

    @Resource(type = SipaBtrMService.class)
    private SipaBtrMService sipaBtrMService;

    @Resource(type = SipaRolMService.class)
    private SipaRolMService sipaRolMService;

    @Resource(type = SipaRtfMService.class)
    private SipaRtfMService sipaRtfMService;

    @Resource(type = CspaFunMService.class)
    private CspaFunMService cspaFunMService;

    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取token
        String token = (String) principalCollection.getPrimaryPrincipal();
        // 根据手机号/用户名查询用户信息
        SipaBurMVo sipaBurMVo = getUserInfo(token);
        if (null == sipaBurMVo) {
            throw new AuthorizationException("用户信息不存在");
        }
        // 授权操作
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 查询用户的角色id
        List<SipaBtrM> sipaBtrMList = sipaBtrMService.listRoleInfoByUserId(sipaBurMVo.getUserid());
        // 角色id集合
        List<String> roleidList = new ArrayList<>();
        sipaBtrMList.forEach(sipaBtrM -> roleidList.add(sipaBtrM.getRoleid()));
        // 根据角色id查询角色信息
        List<SipaRolM> sipaRolMList = sipaRolMService.listSipaRolMByRoleidList(roleidList);
        sipaRolMList.forEach(sipaRolM -> simpleAuthorizationInfo.addRole(sipaRolM.getRoleid()));

        // 根据角色id集合查询对应的权限id
        List<SipaRtfM> SipaRtfMList = sipaRtfMService.listSipaRtfMByRoleidList(roleidList);

        // 设置权限
        SipaRtfMList.forEach(sipaRtfM -> simpleAuthorizationInfo.addStringPermission(sipaRtfM.getFunid()));

        return simpleAuthorizationInfo;
    }

    /**
     * 授权登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.从主体传过来的认证信息中，获得token
        String token = (String) authenticationToken.getPrincipal();
        // 2.根据手机号/用户名查询用户信息
        SipaBurMVo sipaBurMVo = getUserInfo(token);
        if (null == sipaBurMVo) {
            throw new AuthenticationException("用户信息不存在");
        }
        // 3.校验用户
        String errorMessage = JwtUtils.verify(token, sipaBurMVo.getPassword(), JwtUtils.getMobilephone(token), sipaBurMVo.getUserid());
        if (!GlobalConstants.Flag.SUCCESS.equals(errorMessage)) {
            throw new AuthenticationException(errorMessage);
        }
        // 4.是否禁用
        SysAssert.ne(GlobalConstants.Flag.FALSE, sipaBurMVo.getUseFlag(), "您已被禁用，无法登录，请联系管理员");
        return new SimpleAuthenticationInfo(token, token, getName());
    }

    /**
     * 获取用户信息
     *
     * @param token
     * @return com.marke.entity.vo.SipaBurMVo
     * @author marke.huang
     * @date 2018/11/18 15:18
     */
    private SipaBurMVo getUserInfo(String token) {
        // 根据userid
        SipaBurMVo sipaBurMVo = sipaBurMService.getUserInfoByUserid(JwtUtils.getUserid(token));
        // 根据手机号码
        if (null == sipaBurMVo) {
            sipaBurMVo = sipaBurMService.getUserInfoByMobilephone(JwtUtils.getMobilephone(token));
        }

        return sipaBurMVo;
    }
}
