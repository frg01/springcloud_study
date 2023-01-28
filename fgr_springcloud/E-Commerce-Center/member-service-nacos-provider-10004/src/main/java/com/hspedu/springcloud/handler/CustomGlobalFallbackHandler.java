package com.hspedu.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hspedu.springcloud.entity.Result;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 全局fallback处理类
 * 编写处理Java异常或业务异常的方法 static
 */
public class CustomGlobalFallbackHandler {

    public static Result handlerMethod1(Throwable e){
        return Result.error("402","信息=" + e.getMessage());
    }

    public static Result handlerMethod2(Throwable e){
        return Result.error("403","信息=" + e.getMessage());
    }
}
