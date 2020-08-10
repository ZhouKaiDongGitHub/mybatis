package com.luban.mybatis.dao;

import com.luban.mybatis.entity.UserEntity;

import java.util.List;

/**
 * UserDao層接口，提供給Service層調用
 */
public interface UserDao {

    public List<UserEntity> queryAllUser();

    public UserEntity queryUserById(String id);

    public void insertUser(UserEntity userEntity);

    public void updateUser(UserEntity userEntity);

    public void deleteUser(String id);
}
