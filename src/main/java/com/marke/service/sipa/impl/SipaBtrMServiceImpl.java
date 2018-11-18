package com.marke.service.sipa.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marke.entity.mapper.SipaBtrMMapper;
import com.marke.entity.model.SipaBtrM;
import com.marke.service.sipa.SipaBtrMService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户与角色关联表 服务实现类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Service
public class SipaBtrMServiceImpl extends ServiceImpl<SipaBtrMMapper, SipaBtrM> implements SipaBtrMService {

    /**
     * 根据用户id查询所属角色信息
     */
    @Override
    public List<SipaBtrM> listRoleInfoByUserId(String userid) {
        LambdaQueryWrapper<SipaBtrM> queryWrapper = new QueryWrapper<SipaBtrM>().lambda();
        queryWrapper.eq(SipaBtrM::getUserid, userid);
        return super.list(queryWrapper);
    }
}
