package com.marke.service.sipa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.marke.entity.model.SipaBtrM;

import java.util.List;

/**
 * <p>
 * 用户与角色关联表 服务类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
public interface SipaBtrMService extends IService<SipaBtrM> {

    /**
     * 根据用户id查询所属角色信息
     *
     * @param userid
     * @return java.util.List<com.marke.entity.model.SipaBtrM>
     * @author marke.huang
     * @date 2018/11/18 18:15
     */
    List<SipaBtrM> listRoleInfoByUserId(String userid);
}
