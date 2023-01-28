package com.hspedu.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * RibbonRule 配置自己的均衡算法
 */
@Configuration
public class RibbonRule {

    //配置注入自己选择的均衡算法
    @Bean
    public IRule myRibbonRule(){
        //返回随机算法
        return new RandomRule();
    }
}
