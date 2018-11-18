package com.marke.service.sipa.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marke.entity.mapper.SipaBurMMapper;
import com.marke.entity.model.SipaBurM;
import com.marke.entity.vo.SipaBurMVo;
import com.marke.service.sipa.SipaBurMService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Service
public class SipaBurMServiceImpl extends ServiceImpl<SipaBurMMapper, SipaBurM> implements SipaBurMService {
    /**
     * 根据用户userid查询用户信息
     */
    @Override
    public SipaBurMVo getUserInfoByUserid(String userid) {
        return null;
    }

    /**
     * 根据手机号码查询数据
     */
    @Override
    public SipaBurMVo getUserInfoByMobilephone(String mobilephone) {
        return null;
    }
}
