package com.marke.service.sipa.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marke.constant.FieldContants;
import com.marke.entity.mapper.SipaRolMMapper;
import com.marke.entity.model.SipaRolM;
import com.marke.service.sipa.SipaRolMService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色基本信息表 服务实现类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Service
public class SipaRolMServiceImpl extends ServiceImpl<SipaRolMMapper, SipaRolM> implements SipaRolMService {

    /**
     * 根据所有角色id查询角色信息
     */
    @Override
    public List<SipaRolM> listSipaRolMByRoleidList(List<String> roleidList) {
        LambdaQueryWrapper<SipaRolM> queryWrapper = new QueryWrapper<SipaRolM>().lambda();
        queryWrapper.eq(SipaRolM::getDelFlag, FieldContants.PublicFieldValue.DEL_FLAG_NO);
        queryWrapper.in(SipaRolM::getRoleid, roleidList);
        return super.list(queryWrapper);
    }
}
