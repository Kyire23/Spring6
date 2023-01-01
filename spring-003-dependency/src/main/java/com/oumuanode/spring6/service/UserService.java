package com.oumuanode.spring6.service;

import com.oumuanode.spring6.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public void setMySQLUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    //set 注入 必须提供一个set方法 spring 容器会调用这个方法
    public void saveService(){
        userDao.insert();
    }
}
