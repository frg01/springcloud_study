package com.hspedu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.client.RestTemplate;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 配置类 配置注入RestTemplate对象
 */
@Configuration
public class CustomizationBean {

    @Bean
    @LoadBalanced//赋予RestTemplate负载均衡的能力，默认轮询算法
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
