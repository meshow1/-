package com.kuang.service;

import com.kuang.dao.UserDao;
import com.kuang.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void getuser() {
        userDao.getuser();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
