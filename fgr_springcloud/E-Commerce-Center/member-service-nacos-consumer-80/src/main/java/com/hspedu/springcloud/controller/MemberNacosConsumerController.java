package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.MemberOpenfeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@RestController
@Slf4j
public class MemberNacosConsumerController {

    //member-service-nacos-provider注册到nacos的服务名
    public static final String MEMBER_SERVICE_NACOS_PROVIDER_URL =
            "http://member-service-nacos-provider";

    @Resource
    private RestTemplate restTemplate;

    //装配MemberOpenfeignService
    @Resource
    private MemberOpenfeignService memberOpenfeignService;

    //通过openfeign 实现远程调用
    @GetMapping("member/openfeign/consumer/get/{id}")
    public Result<Member> getMemberOpenfeignById(@PathVariable("id")Long id){
        //使用接口方式
        return memberOpenfeignService.getMemberById(id);
    }
    //添加member 接口
    @PostMapping("/member/consumer/save")
    public Result<Member> save(Member member){
        log.info("service-consumer-member={}",member);
        return restTemplate.postForObject(MEMBER_SERVICE_NACOS_PROVIDER_URL + "/member/save",member,Result.class);
    }
    //查询member 接口
    @GetMapping("/member/nacos/consumer/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id){
        return restTemplate.getForObject(MEMBER_SERVICE_NACOS_PROVIDER_URL
                + "/member/get/" + id,Result.class);
    }
}
