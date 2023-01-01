package com.oumuanode.spring6.service.impl;

import com.oumuanode.spring6.dao.UserDao;
import com.oumuanode.spring6.dao.impl.UserDaoImplForMySQL;
import com.oumuanode.spring6.service.UserService;

public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //考虑到OCP 依赖倒置原则 上不能依赖下
    private UserDao userDao;
    public void deleteUser() {
        userDao.deleteById();
    }

}
