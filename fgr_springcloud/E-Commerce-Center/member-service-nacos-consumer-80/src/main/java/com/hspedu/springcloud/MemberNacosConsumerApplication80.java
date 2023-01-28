package com.hspedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient //引入的是nacos发现注解
public class MemberNacosConsumerApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosConsumerApplication80.class,args);
    }
}
