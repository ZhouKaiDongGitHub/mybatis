package com.luban.test;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;
import com.luban.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
//            User user = sqlSession.selectOne("UserMapper.selectUser", 1);
//            System.out.println(user);
            UserDao userDao = new UserDaoImpl(sqlSession);
            //queryUserById
            System.out.println(userDao.queryUserById("1"));
            //queryUserAl
            List<User> userList = userDao.queryUserAll();
            for (User user : userList) {
                System.out.println(user);
            }
            //insertUse
            /*User user = new User();
            user.setId("3");
            user.setAge(16);
            user.setBirthday(new Date("1990/09/02"));
            user.setName("大鹏");
            user.setPassword("123456");
            user.setSex(1);
            user.setUserName("evan");
            userDao.insertUser(user);
            sqlSession.commit();*/
            //updateUser
            /*User user = new User();
            user.setBirthday(new Date());
            user.setName("静鹏");
            user.setPassword("654321");
            user.setSex(1);
            user.setUserName("evanjin");
            user.setId("1");
            userDao.updateUser(user);
            sqlSession.commit();*/
            //deleteUser
            userDao.deleteUser("3");
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }


    }
}
