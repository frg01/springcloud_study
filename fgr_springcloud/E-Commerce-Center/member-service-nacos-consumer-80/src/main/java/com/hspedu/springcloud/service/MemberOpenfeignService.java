package com.hspedu.springcloud.service;

import com.hspedu.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@FeignClient(value = "member-service-nacos-provider",fallback = MemberFeignFallbackService.class)
public interface MemberOpenfeignService {

    //远程调用方式get url=http://member-service-nacos-provider//member/get/{id}
    //openfeign通过接口调用远程服务
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id);

}
