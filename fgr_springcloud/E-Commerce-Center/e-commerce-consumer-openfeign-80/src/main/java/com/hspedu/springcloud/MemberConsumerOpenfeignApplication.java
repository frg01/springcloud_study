package com.hspedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients//起动openfeignClient
public class MemberConsumerOpenfeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberConsumerOpenfeignApplication.class,args);
    }
}
