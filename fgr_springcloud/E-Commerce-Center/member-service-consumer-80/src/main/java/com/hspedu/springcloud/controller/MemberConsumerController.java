package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */

@Slf4j
public class MemberConsumerController {

    //定义一个基础的url地址
    /*
    1.EMBER-SERVICE-PROVIDER是服务提供方【集群】，注册到Eureka Server的名称
    2.服务提供方[集群]对外暴露的名称为EMBER-SERVICE-PROVIDER
    3.目前EMBER-SERVICE-PROVIDER有两个可获取的组件地址
        需要添加一个注解@LoadBalanced 赋予RestTemplate负载均衡的能力，
        根据负载均衡算法选择某个服务去访问 默认轮询算法，也可以自己配算法
     */
    public static final String MEMBER_SERVICE_PROVIDER_URL =
            "http://MEMBER-SERVICE-PROVIDER";
    //配置RestTemplate
    @Resource
    private RestTemplate restTemplate;

    //装配DiscoveryClient
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/member/consumer/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        //遍历服务
        for (String service : services) {
            log.info("服务名={}",service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("id={},host={},port={},uri={}",instance.getServiceId(),instance.getHost(),instance.getPort(),instance.getUri());
            }
        }
        return discoveryClient;
    }

    //添加member对象到数据库/表
    @PostMapping("/member/consumer/save")
    public Result<Member> save(Member member){
        log.info("service-consumer-member={}",member);
        //1.发送地址 2.发送对象 3.返回Result
       return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER_URL + "/member/save", member, Result.class);
    }

    //方法/接口  根据id调用服务接口 返回member接口
    @GetMapping("/member/consumer/get/{id}")
        public Result<Member> getMemberById(@PathVariable("id") Long id){
        return restTemplate.getForObject(MEMBER_SERVICE_PROVIDER_URL
                + "/member/get/" + id,Result.class);
    }
}
