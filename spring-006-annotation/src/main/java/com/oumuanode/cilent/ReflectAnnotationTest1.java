package com.oumuanode.cilent;

import org.springframework.stereotype.Component;

public class ReflectAnnotationTest1 {
    //通过反射机制读取注解
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.oumuanode.bean.User");
        //判断类上有无这个注解
        if (aClass.isAnnotationPresent(Component.class)){
            //获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);
            System.out.println(annotation.value());
        }

    }

}
