package com.hspedu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@RestController
@Slf4j
@RefreshScope
public class NacosConfigClientController {

    @Value("${config.ip}")//config.ip 赋给 configIp
    private String configIp;

    @Value("${config.name}")
    private String configName;

    @GetMapping("/nacos/config/ip")
    public String getConfigIp(){
        return configIp;
    }

    @GetMapping("/nacos/config/name")
    public String getConfigName(){
        return configName;
    }
}
