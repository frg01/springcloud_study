package com.hspedu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.TimeUtil;
import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.handler.CustomGlobalBlockHandler;
import com.hspedu.springcloud.handler.CustomGlobalFallbackHandler;
import com.hspedu.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Slf4j
@RestController
public class MemberController {

//    装配MemberService
    @Resource
    private MemberService memberService;

    private static int num = 0;//执行的计数器

    //全局限流处理类，使用限流的信息
    /*
    blockHandlerClass全局限流处理类
    blockHandler指定上面类使用哪一个方法
    fallbackClass 全局fallback 处理类 出现Java异常
    fallback指定方法
    exceptionsToIgnore 排除指定异常类的自定义处理，使用默认处理
     */
    @SentinelResource(value = "t6",
            fallbackClass = CustomGlobalFallbackHandler.class,
            fallback = "handlerMethod1",
            blockHandlerClass = CustomGlobalBlockHandler.class,
            blockHandler = "handlerMethod1",
            exceptionsToIgnore = NullPointerException.class)

    @GetMapping("/t6")
    public Result t6(){
        //访问为5的倍数后 出现java异常
        if (++num % 5 == 0){
            throw new RuntimeException("num的值异常num=" + num);
        }
        if (num % 6 == 0){
            throw new NullPointerException("null指针异常");
        }
        log.info("执行t6 线程id={}",Thread.currentThread().getId());
        return Result.success("200","t6()执行成功");
    }

    //完成对热点key限流的测试
    //SentinelResource 用来指定限流资源，value限流资源名称自己指定，
    // blockHandler 当出现限流时 由此名方法执行
    @SentinelResource(value = "news",blockHandler = "newsBlockHandler")
    @GetMapping("/news")
    public Result queryNews(@RequestParam(value = "id",required = false)String id,
                            @RequestParam(value = "type",required = false)String type){
        //DB或缓存获取
        log.info("到DB查询新闻");
        return Result.success("返回id=" + id + "新闻 from DB");
    }

    //热点key限制/限流异常处理方法
    public Result newsBlockHandler(String id, String type, BlockException blockException){
         return Result.success("查询id=" + id + "新闻 出发热点限流保护 sorry。。。");
    }


    @GetMapping("/t5")
    public Result t5(){
        //设计异常比例达到50%
        if(++num % 2 == 0){
            //制造一个异常
            System.out.println(3/0);
        }
        log.info("熔断降级测试异常比例 执行t5 线程id={}",Thread.currentThread().getId());
        return Result.success("t5执行");
    }

    @GetMapping("/t4")
    public Result t4(){
        //设计异常比例达到50%
        if(++num % 2 == 0){
            //制造一个异常
            System.out.println(3/0);
        }
        log.info("熔断降级测试异常比例 执行t4 线程id={}",Thread.currentThread().getId());
        return Result.success("t4执行");
    }

    @GetMapping("/t1")
    public Result t1(){
        return Result.success("t1执行");
    }

    @GetMapping("/t2")
    public Result t2(){
        //让线程休眠1s  执行1s => 当多少个请求就会造成超时
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("执行t2 id={}",Thread.currentThread().getId());
        return Result.success("t2执行");

    }


    @PostMapping("/member/save")
    public Result save(@RequestBody Member member){
        log.info("serv ice-provider-member={}",member);
        int affected = memberService.save(member);
        if (affected > 0){
            return Result.success("添加会员成功 member-service-nacos-provider-10004",affected);
        }else{
            return Result.error("401","添加会员失败");
        }
    }

    @GetMapping("/t3")
    public Result t3(){
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.success("t3执行");
    }

    //查询的方法
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id){
        //让线程休眠1s
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    @GetMapping(value = "/member/get",params = "id")
//    public Result getMemberById(Long id){
        Member member = memberService.queryMemberById(id);
//        String color = request.getParameter("color");
//        String address = request.getParameter("address");
        if (member != null){
            return Result.success("查询会员成功 member-service-nacos-provider-10004",member);
        }else{
            return Result.error("402","ID=" + id + "，不存在");
        }
    }

}
