package com.oumuanode.spring6.service;

import com.oumuanode.spring6.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public void setMySQLUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    //set ע�� �����ṩһ��set���� spring ����������������
    public void saveService(){
        userDao.insert();
    }
}
