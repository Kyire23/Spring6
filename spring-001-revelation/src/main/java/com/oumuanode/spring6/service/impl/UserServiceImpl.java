package com.oumuanode.spring6.service.impl;

import com.oumuanode.spring6.dao.UserDao;
import com.oumuanode.spring6.dao.impl.UserDaoImplForMySQL;
import com.oumuanode.spring6.service.UserService;

public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //���ǵ�OCP ��������ԭ�� �ϲ���������
    private UserDao userDao;
    public void deleteUser() {
        userDao.deleteById();
    }

}
