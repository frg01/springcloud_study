package com.hspedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * @EnableEurekaServer 表示该程序作为EurekaServer运行
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication9001.class,args);
    }
}
