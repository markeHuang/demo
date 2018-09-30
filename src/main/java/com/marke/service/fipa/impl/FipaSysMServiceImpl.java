package com.marke.service.fipa.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marke.constant.FieldContants;
import com.marke.entity.mapper.FipaSysMMapper;
import com.marke.entity.model.FipaSysM;
import com.marke.service.fipa.FipaSysMService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统参数设定表 服务实现类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
@Service
public class FipaSysMServiceImpl extends ServiceImpl<FipaSysMMapper, FipaSysM> implements FipaSysMService {

    /**
     * 查询系统配置
     */
    @Override
    public List<FipaSysM> listSystemConfig() {
        LambdaQueryWrapper<FipaSysM> queryWrapper = new QueryWrapper<FipaSysM>().lambda();
        queryWrapper.eq(FipaSysM::getDelFlag, FieldContants.PublicFieldValue.DEL_FLAG_NO);
        return super.list(queryWrapper);
    }

    /**
     * 根据参数名称更新参数值
     */
    @Override
    public void updateFipaSysMByParamName(FipaSysM fipaSysM, String paramName) {
        LambdaQueryWrapper<FipaSysM> queryWrapper = new QueryWrapper<FipaSysM>().lambda();
        queryWrapper.eq(FipaSysM::getParamName, paramName);
        super.update(fipaSysM, queryWrapper);
    }
}
