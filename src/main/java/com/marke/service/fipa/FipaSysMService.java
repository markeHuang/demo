package com.marke.service.fipa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.marke.entity.model.FipaSysM;

import java.util.List;

/**
 * <p>
 * 系统参数设定表 服务类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
public interface FipaSysMService extends IService<FipaSysM> {

    /**
     * 查询系统配置
     *
     * @param
     * @return java.util.List<com.marke.entity.model.FipaSysM>
     * @author jiangming.huang
     * @date 2018/9/27 0027 下午 3:36
     */
    List<FipaSysM> listSystemConfig();

    /**
     * 根据参数名称更新参数值
     *
     * @param fipaSysM
     * @param paramName
     * @return void
     * @author jiangming.huang
     * @date 2018/9/27 0027 下午 4:23
     */
    void updateFipaSysMByParamName(FipaSysM fipaSysM, String paramName);

}
