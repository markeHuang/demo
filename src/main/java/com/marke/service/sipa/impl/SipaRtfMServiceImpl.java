package com.marke.service.sipa.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marke.entity.mapper.SipaRtfMMapper;
import com.marke.entity.model.SipaRtfM;
import com.marke.service.sipa.SipaRtfMService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色与权限关联表 服务实现类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Service
public class SipaRtfMServiceImpl extends ServiceImpl<SipaRtfMMapper, SipaRtfM> implements SipaRtfMService {

    /**
     * 根据角色id集合查询对应的权限id
     */
    @Override
    public List<SipaRtfM> listSipaRtfMByRoleidList(List<String> roleidList) {
        LambdaQueryWrapper<SipaRtfM> queryWrapper = new QueryWrapper<SipaRtfM>().lambda();
        queryWrapper.in(SipaRtfM::getRoleid, roleidList);
        return super.list(queryWrapper);
    }
}
