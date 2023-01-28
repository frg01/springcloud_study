package com.hspedu.springcloud.service;

import com.hspedu.springcloud.entity.Result;
import org.springframework.stereotype.Component;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Component
public class MemberFeignFallbackService implements MemberOpenfeignService{
    @Override
    public Result getMemberById(Long id) {
        return Result.error("500","被调用服务异常，熔断降级，防止线程堆积");
    }
}
