package com.marke.service.sipa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.marke.entity.model.SipaRolM;

import java.util.List;

/**
 * <p>
 * 角色基本信息表 服务类
 * </p>
 *
 * @author vteam-generator
 * @since 2018-09-27
 */
public interface SipaRolMService extends IService<SipaRolM> {
    /**
     * 根据所有角色id查询角色信息
     *
     * @param roleidList
     * @return java.util.List<com.marke.entity.model.SipaRolM>
     * @author marke.huang
     * @date 2018/11/18 18:24
     */
    List<SipaRolM> listSipaRolMByRoleidList(List<String> roleidList);
}
