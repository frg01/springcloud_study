package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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


    @PostMapping("/member/save")
    public Result save(@RequestBody Member member){
        log.info("serv ice-provider-member={}",member);
        int affected = memberService.save(member);
        if (affected > 0){
            return Result.success("添加会员成功",affected);
        }else{
            return Result.error("401","添加会员失败");
        }
    }

    //查询的方法
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id, HttpServletRequest request){
        Member member = memberService.queryMemberById(id);
        String color = request.getParameter("color");
        String address = request.getParameter("address");
        if (member != null){
            return Result.success("查询会员成功 member-service-provider-10000" + color + "=" + address,member);
        }else{
            return Result.error("402","ID=" + id + "，不存在");
        }
    }

}
