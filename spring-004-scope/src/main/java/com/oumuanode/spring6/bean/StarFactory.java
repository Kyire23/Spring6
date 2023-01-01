package com.oumuanode.spring6.bean;

public class StarFactory {
    //工厂中有一个静态方法
    public static Star get(){
        return new Star();
    }
}
