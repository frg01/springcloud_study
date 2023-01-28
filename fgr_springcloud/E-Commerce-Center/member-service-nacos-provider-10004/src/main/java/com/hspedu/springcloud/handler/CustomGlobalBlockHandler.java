package com.hspedu.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hspedu.springcloud.entity.Result;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 全局限流处理类
 * 中此类中了可以编写限流处理方法 要求时静态方法
 */
public class CustomGlobalBlockHandler {

    public static Result handlerMethod1(BlockException blockException){
        return Result.error("400","客户自定义限流处理方法handlerMethod1");
    }

    public static Result handlerMethod2(BlockException blockException){
        return Result.error("402","客户自定义限流处理方法handlerMethod2");
    }
}
