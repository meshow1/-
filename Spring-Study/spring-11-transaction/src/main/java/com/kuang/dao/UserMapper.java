package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();

    int addUser(User user);

    int deleteUser(int id);
}
