package com.hong.musichqend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hong.musichqend.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author HQ
 * @Date: 2024/7/6
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    @Select("select * from user where name = #{name}")
    User getByName(String name);
}
