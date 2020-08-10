package com.luban.mybatis.dao.impl;

import com.luban.mybatis.dao.UserDao;
import com.luban.mybatis.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class UserDaoImplTest {

    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);

    }

    @Test
    public void queryAllUser() {
        List<UserEntity> userList = this.userDao.queryAllUser();
        for (UserEntity user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserById() {
        System.out.println(this.userDao.queryUserById("1"));
    }

    @Test
    public void insertUser() {
        UserEntity user = new UserEntity();
        user.setAge(16);
        user.setBirthday(new Date("1990/09/02"));
        user.setName("大鹏");
        user.setPassword("123456");
        user.setSex(1);
        user.setUser_name("evan");
        this.userDao.insertUser(user);
        this.sqlSession.commit();
    }


    @Test
    public void updateUser() {
        UserEntity user = new UserEntity();
        user.setBirthday(new Date());
        user.setName("静鹏");
        user.setPassword("654321");
        user.setSex(1);
        user.setUser_name("evanjin");
        user.setId("1");
        this.userDao.updateUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() {
        this.userDao.deleteUser("4");
        this.sqlSession.commit();
    }
}