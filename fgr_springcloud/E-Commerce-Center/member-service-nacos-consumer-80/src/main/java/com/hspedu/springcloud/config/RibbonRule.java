package com.hspedu.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 配置负载均衡算法
 */
@Configuration
public class RibbonRule {

    @Bean
    public IRule myRibbonRule(){
        //返回随机算法
        return new RandomRule();
    }
}
