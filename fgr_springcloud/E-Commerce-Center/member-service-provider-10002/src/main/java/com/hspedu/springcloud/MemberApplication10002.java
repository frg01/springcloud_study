package com.hspedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
//@EnableEurekaClient 该程序标识未eureka-client
@EnableEurekaClient
//exclude是排除DataSourceAutoConfiguration的自动配置，这样在依赖添加了mybatis依赖就不会报错了
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MemberApplication10002 {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication10002.class,args);
    }
}
