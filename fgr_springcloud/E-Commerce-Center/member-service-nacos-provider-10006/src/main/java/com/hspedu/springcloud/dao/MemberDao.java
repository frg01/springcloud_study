package com.hspedu.springcloud.dao;

import com.hspedu.springcloud.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Mapper
public interface MemberDao {
    //定义接口中的方法 根据id返回member信息
    public Member queryMemberById(Long id);

    //添加member
    public int save(Member member);
}
