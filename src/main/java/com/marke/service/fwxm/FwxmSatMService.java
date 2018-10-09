package com.marke.service.fwxm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.marke.entity.model.FwxmSatM;

/**
 * <p>
 * 微信安全访问令牌存储表 服务类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
public interface FwxmSatMService extends IService<FwxmSatM> {

    /**
     * 获取微信公众号开发者的accessToken
     *
     * @param
     * @return java.lang.String
     * @author jiangming.huang
     * @date 2018/10/9 0009 下午 5:40
     */
    String getAccessToken();

}
