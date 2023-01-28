package com.shpedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication9002.class,args);
    }
}
