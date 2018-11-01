package com.marke.plugin.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.marke.constant.FieldContants;
import com.marke.service.common.CommonService;
import com.marke.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 数据持久化前置处理器
 *
 * @author marke.huang
 * @date 2018/11/1 0001 下午 1:42
 */
@Service
@Slf4j
public class BeforePersistenceHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setRefcode(metaObject);
        setCreateUser(metaObject);
        setCreateDate(metaObject);
        setLastModUser(metaObject);
        setLastModDate(metaObject);
        setCreateEdtid(metaObject);
        setDataStatus(metaObject);

        // 如果开启了数据安全策略，则根据策略加密字段值 TODO

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setLastModUser(metaObject);
        setLastModDate(metaObject);
        setModEdtid(metaObject);

        // 如果开启了数据安全策略，则根据策略加密字段值 TODO

    }


    /**
     * 设置流水号
     *
     * @param metaObject 数据对象
     * @return void
     * @author andy.sher
     * @date 2018/8/13 14:49
     */
    private void setRefcode(MetaObject metaObject) {
        if (null == metaObject.getValue(FieldContants.PublicField.REFCODE)) {
            CommonService commonService = SpringContextUtils.getBean(CommonService.class);
            final Class<?> objClass = metaObject.getOriginalObject().getClass().getSuperclass();
            setFieldValByName(FieldContants.PublicField.REFCODE, commonService.getMaxRefcodeByBeanClass(objClass), metaObject);
        }
    }

    /**
     * 设置创建人
     *
     * @param metaObject 数据对象
     * @return void
     * @author andy.sher
     * @date 2018/8/13 14:49
     */
    private void setCreateUser(MetaObject metaObject) {
        if (metaObject.hasGetter(FieldContants.PublicField.CREATEUSER) && null == metaObject.getValue(FieldContants.PublicField.CREATEUSER)) {
            setFieldValByName(FieldContants.PublicField.CREATEUSER, "admin", metaObject);
        }
    }

    /**
     * 设置修改人
     *
     * @param metaObject 数据对象
     * @return void
     * @author andy.sher
     * @date 2018/8/13 14:49
     */
    private void setLastModUser(MetaObject metaObject) {
        setFieldValByName(FieldContants.PublicField.LASTMODUSER, "admin", metaObject);
    }

    /**
     * 设置创建日期
     *
     * @param metaObject 数据对象
     * @return void
     * @author andy.sher
     * @date 2018/8/13 14:49
     */
    private void setCreateDate(MetaObject metaObject) {
        setFieldValByName(FieldContants.PublicField.CREATEDATE, LocalDateTime.now(), metaObject);
    }

    /**
     * 设置修改日期
     *
     * @param metaObject 数据对象
     * @return void
     * @author andy.sher
     * @date 2018/8/13 14:49
     */
    private void setLastModDate(MetaObject metaObject) {
        setFieldValByName(FieldContants.PublicField.LASTMODDATE, LocalDateTime.now(), metaObject);
    }

    /**
     * 设置数据状态
     *
     * @param metaObject 数据对象
     * @return void
     * @author andy.sher
     * @date 2018/8/13 14:49
     */
    private void setDataStatus(MetaObject metaObject) {
        setFieldValByName(FieldContants.PublicField.DATA_STATUS, FieldContants.PublicFieldValue.DATA_STATUS_EFFECTIVE, metaObject);
    }

    /**
     * 设置创建时的操作类型
     *
     * @param metaObject 数据对象
     * @return void
     * @author andy.sher
     * @date 2018/8/13 14:49
     */
    private void setCreateEdtid(MetaObject metaObject) {
        if (metaObject.hasGetter(FieldContants.PublicField.EDTID) && null == metaObject.getValue(FieldContants.PublicField.EDTID)) {
            setFieldValByName(FieldContants.PublicField.EDTID, FieldContants.PublicFieldValue.EDTID_NEW, metaObject);
        }
    }

    /**
     * 设置修改时的操作类型
     *
     * @param metaObject 数据对象
     * @return void
     * @author andy.sher
     * @date 2018/8/13 14:49
     */
    private void setModEdtid(MetaObject metaObject) {
        setFieldValByName(FieldContants.PublicField.EDTID, FieldContants.PublicFieldValue.EDTID_MOD, metaObject);
    }

}
