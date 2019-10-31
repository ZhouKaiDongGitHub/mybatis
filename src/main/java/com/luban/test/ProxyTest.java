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
import java.util.List;

public class ProxyTest {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            System.out.println(userDao.queryUserById("1"));
        }finally {
            sqlSession.close();
        }


    }
}
