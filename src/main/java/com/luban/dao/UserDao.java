package com.luban.dao;

import com.luban.model.User;

import java.util.List;

public interface UserDao {
    /**
     * 根据id查询用户信息
     */
    public User queryUserById(String id);

    /**
     * 查询所有用户信息
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     */
    public void insertUser(User user);

    /**
     * 更新用户信息
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     */
    public void deleteUser(String id);
}
