package com.marke.entity.vo;

import com.marke.entity.model.FwxmSatM;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微信安全访问令牌存储表扩展类
 *
 * @author marke.huang
 * @date 2018/10/9 0009 下午 5:51
 */
@Getter
@Setter
@ToString(callSuper = true)
public class FwxmSatMVo extends FwxmSatM {
    private static final long serialVersionUID = -9076640892700403365L;
}
