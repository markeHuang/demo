package com.marke.api.controller.wx;

import com.marke.config.SysConfiguration;
import com.marke.service.fipa.FipaSysMService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jiangming.huang
 * @date 2018/10/9 0009 下午 5:21
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Resource(type = SysConfiguration.class)
    private SysConfiguration sysConfiguration;

    @Resource(type = FipaSysMService.class)
    private FipaSysMService fipaSysMService;

    @GetMapping("/getWxTemporaryCode")
    public void getWxTemporaryCode() {
        sysConfiguration.getPWxJoin();
        System.out.println(fipaSysMService);

    }
}
