package com.hspedu.springcloud;

import com.hspedu.springcloud.dao.MemberDao;
import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@SpringBootTest
@Slf4j
public class MemberApplicationTest {

    //装配DAO
    @Resource
    private MemberDao memberDao;
    //装配Service
    @Resource
    private MemberService memberService;

    //强调 使用org.junit.jupiter.api.Test
    @Test
    public void queryMemberById(){
        Member member = memberService.queryMemberById(2l);
        log.info("member={}",member);
    }

    @Test
    public void save(){

        Member m = new Member(null, "狐狸精", "123", "1300000000", "hulijing@sohu.com", 1);

        int affected = memberService.save(m);
        log.info("affected={}",affected);
    }
}
