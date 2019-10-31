package com.luban.dao;

import com.luban.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User queryUserById(String id) {
        return this.sqlSession.selectOne("UserMapper.queryUserById", id);
    }

    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserMapper.queryUserAll");
    }

    public void insertUser(User user) {
        this.sqlSession.insert("UserMapper.insertUser", user);
    }

    public void updateUser(User user) {
        this.sqlSession.update("UserMapper.updateUser", user);
    }

    public void deleteUser(String id) {
        this.sqlSession.delete("UserMapper.deleteUser", id);
    }
}
