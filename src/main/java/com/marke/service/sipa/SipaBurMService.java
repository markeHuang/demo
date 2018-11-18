package com.marke.service.sipa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.marke.entity.model.SipaBurM;
import com.marke.entity.vo.SipaBurMVo;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
public interface SipaBurMService extends IService<SipaBurM> {

    /**
     * 根据用户userid查询用户信息
     *
     * @param
     * @return com.marke.entity.vo.SipaBurMVo
     * @author marke.huang
     * @date 2018/11/17 23:02
     */
    SipaBurMVo getUserInfoByUserid(String userid);

    /**
     * 根据手机号码查询数据
     *
     * @param mobilephone
     * @return com.marke.entity.vo.SipaBurMVo
     * @author marke.huang
     * @date 2018/11/17 23:02
     */
    SipaBurMVo getUserInfoByMobilephone(String mobilephone);

}
