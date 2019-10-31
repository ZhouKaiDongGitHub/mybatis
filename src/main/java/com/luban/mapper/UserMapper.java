package com.luban.mapper;

import com.luban.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * spring-mybatis
 */
public interface UserMapper {
    @Select("select * from tb_user")
    public List<User> queryUserList();
}
