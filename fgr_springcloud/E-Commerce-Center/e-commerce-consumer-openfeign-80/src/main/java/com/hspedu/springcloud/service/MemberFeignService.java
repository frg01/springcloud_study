package com.hspedu.springcloud.service;

import com.hspedu.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Component
@FeignClient(value = "MEMBER-SERVICE-PROVIDER")
public interface MemberFeignService {
    //定义方法，远程调用的接口
    /*
    1.此注解与方法的 远程调用的方式是get，
    url=MEMBER-SERVICE-PROVIDER/member/get/{id}
    openfeign 会根据负载均衡来决定调运不同provider 默认是轮询
    openfeign支持了springmvc注解，并且使用接口解耦了
     */
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id);
}
