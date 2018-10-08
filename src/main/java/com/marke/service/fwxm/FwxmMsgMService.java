package com.marke.service.fwxm;

import java.util.Map;

/**
 * 微信消息服务
 *
 * @author marke.huang
 * @date 2018/9/30 0030 下午 2:17
 */
public interface FwxmMsgMService {

    /**
     * 文本消息处理
     *
     * @param map
     * @param reqContent
     * @param isBindWx
     *              是否绑定微信
     * @return java.lang.String
     * @author jiangming.huang
     * @date 2018/10/8 0008 下午 5:13
     */
    String processTextMsg(Map<String, String> map, String reqContent, Boolean isBindWx);

}
