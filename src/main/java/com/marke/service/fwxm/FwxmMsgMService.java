package com.marke.service.fwxm;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信消息服务
 *
 * @author marke.huang
 * @date 2018/9/30 0030 下午 2:17
 */
public interface FwxmMsgMService {

    /**
     * 微信消息处理
     *
     * @param request
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/9/30 0030 下午 2:18
     */
    String processMsg(HttpServletRequest request);
}
