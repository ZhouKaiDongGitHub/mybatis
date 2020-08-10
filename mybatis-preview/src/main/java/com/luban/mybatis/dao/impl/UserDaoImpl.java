package com.luban.mybatis.dao.impl;

import com.luban.mybatis.entity.UserEntity;
import com.luban.mybatis.dao.UserDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<UserEntity> queryAllUser() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    public UserEntity queryUserById(String id) {
        return this.sqlSession.selectOne("UserDao.queryUserById", id);
    }

    public void insertUser(UserEntity userEntity) {
        this.sqlSession.insert("UserDao.insertUser", userEntity);
    }

    public void updateUser(UserEntity userEntity) {
        this.sqlSession.update("UserDao.updateUser", userEntity);
    }

    public void deleteUser(String id) {
        this.sqlSession.delete("UserDao.deleteUser", id);
    }
}
