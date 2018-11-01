package com.marke.service.fwxm.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marke.config.SysConfiguration;
import com.marke.constant.GlobalConstants;
import com.marke.entity.mapper.FwxmSatMMapper;
import com.marke.entity.model.FwxmSatM;
import com.marke.entity.vo.FwxmSatMVo;
import com.marke.remote.client.WxHttpsClient;
import com.marke.service.fwxm.FwxmSatMService;
import com.marke.utils.StringUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 微信安全访问令牌存储表 服务实现类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Service
public class FwxmSatMServiceImpl extends ServiceImpl<FwxmSatMMapper, FwxmSatM> implements FwxmSatMService {

    @Resource(type = SysConfiguration.class)
    private SysConfiguration sysConfiguration;

    @Resource(type = WxHttpsClient.class)
    private WxHttpsClient wxHttpsClient;

    /**
     * 默认token保存1小时
     */
    private final static Long DURATION = 1L;

    /**
     * 获取AccessToken
     */
    @Override
    @PostConstruct
    public String getAccessToken() {
        // 未开启直接返回空
        if (GlobalConstants.Flag.FALSE.equals(sysConfiguration.getPWxOpen())) {
            return null;
        }
        // 获取公众号的AccessToken
        FwxmSatMVo fwxmSatMVo = new FwxmSatMVo();
        fwxmSatMVo.setCreateUser(GlobalConstants.Flag.ADMIN);
        List<FwxmSatMVo> fwxmSatMVoList = this.listWxAccessTokenByCondition(fwxmSatMVo);
        if (CollectionUtils.isEmpty(fwxmSatMVoList)) {
            // 获取access_token
            String accessToken = this.getAccessTokenData();
            // 当前时间
            LocalDateTime nowDate = LocalDateTime.now();
            // 计算过期时间(默认加一个小时)
            LocalDateTime failureDate = LocalDateTime.now().plusHours(DURATION);
            // 初始化数据
            fwxmSatMVo.setAccessToken(accessToken);
            fwxmSatMVo.setCreateDate(nowDate);
            fwxmSatMVo.setCreateUser(GlobalConstants.Flag.ADMIN);
            fwxmSatMVo.setFailureDate(failureDate);
            // 插入数据库
            super.save(fwxmSatMVo);
            return accessToken;
        } else {
            // 获取WxAccessToken
            fwxmSatMVo = fwxmSatMVoList.get(0);
            // 当前时间
            LocalDateTime nowDate = LocalDateTime.now();
            // 判断accessToken是否失效
            if (nowDate.compareTo(fwxmSatMVo.getFailureDate()) <= 0) {
                String accessToken = fwxmSatMVo.getAccessToken();
                return accessToken;
            } else {
                // 失效更新accessToken
                String accessToken = this.getAccessTokenData();
                // 初始化数据
                fwxmSatMVo.setAccessToken(accessToken);
                fwxmSatMVo.setFailureDate(LocalDateTime.now().plusHours(DURATION));
                // 更新数据库
                super.updateById(fwxmSatMVo);
                return accessToken;
            }
        }
    }

    /**
     * 获取access_token
     *
     * @param
     * @return java.lang.String
     * @author jiangming.huang
     * @date 2018/11/1 0001 上午 10:31
     */
    private String getAccessTokenData() {
        // 开发者ID
        String appid = sysConfiguration.getPWxAppId();
        // 开发者密码
        String appsecret = sysConfiguration.getPWxAppSecret();
        // 拼接获取token的URL
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret="
                + appsecret;
        // 请求微信获取数据
        JSONObject result = wxHttpsClient.httpsRequest(url, "GET", "");
        // 获取access_token
        String access_token = result.getString("access_token");
        return access_token;
    }

    /**
     * 根据条件查询AccessToken
     *
     * @param fwxmSatMVo
     * @return java.util.List<com.marke.entity.vo.FwxmSatMVo>
     * @author marke.huang
     * @date 2018/10/9 0009 下午 6:02
     */
    private List<FwxmSatMVo> listWxAccessTokenByCondition(FwxmSatMVo fwxmSatMVo) {
        LambdaQueryWrapper<FwxmSatM> queryWrapper = new QueryWrapper<FwxmSatM>().lambda();
        if (StringUtils.isNotBlank(fwxmSatMVo.getCreateUser())) {
            queryWrapper.eq(FwxmSatM::getCreateUser, fwxmSatMVo.getCreateUser());
        }
        List<FwxmSatMVo> fwxmSatMVoList = new ArrayList<>();
        List<FwxmSatM> fwxmSatMList = list(queryWrapper);
        if (CollectionUtils.isNotEmpty(fwxmSatMList)) {
            for (FwxmSatM fwxmSatM : fwxmSatMList) {
                FwxmSatMVo temp = new FwxmSatMVo();
                BeanUtils.copyProperties(fwxmSatM, temp);
                fwxmSatMVoList.add(temp);
            }
        }
        return fwxmSatMVoList;
    }
}
