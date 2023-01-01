package com.oumuanode.spring6.dao.impl;

import com.oumuanode.spring6.dao.UserDao;

public class UserDaoImplForMySQL implements UserDao {
    public void deleteById() {
        System.out.println("Mysql数据库正在删除用户信息....");
    }
}
