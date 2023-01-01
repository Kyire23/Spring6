package com.oumuanode.spring6.web;

import com.oumuanode.spring6.service.UserService;
import com.oumuanode.spring6.service.impl.UserServiceImpl;

public class UserAction {
    private UserService userService;

    public void deleteRequest(){
        userService.deleteUser();
    }
}
