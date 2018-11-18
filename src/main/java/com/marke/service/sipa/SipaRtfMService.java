package com.marke.service.sipa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.marke.entity.model.SipaRtfM;

import java.util.List;

/**
 * <p>
 * 角色与权限关联表 服务类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
public interface SipaRtfMService extends IService<SipaRtfM> {

    /**
     * 根据角色id集合查询对应的权限id
     *
     * @param roleidList
     * @return java.util.List<com.marke.entity.model.SipaRtfM>
     * @author marke.huang
     * @date 2018/11/18 19:09
     */
    List<SipaRtfM> listSipaRtfMByRoleidList(List<String> roleidList);
}
