package com.luban.test;

import com.luban.config.AppConfig;
import com.luban.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMybatisTest  {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserMapper userMapper = context.getBean(UserMapper.class);
        System.out.println(userMapper.queryUserList());
        System.out.println(userMapper.queryUserList());
    }
}
