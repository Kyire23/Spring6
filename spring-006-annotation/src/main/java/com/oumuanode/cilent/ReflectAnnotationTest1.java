package com.oumuanode.cilent;

import org.springframework.stereotype.Component;

public class ReflectAnnotationTest1 {
    //ͨ��������ƶ�ȡע��
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.oumuanode.bean.User");
        //�ж������������ע��
        if (aClass.isAnnotationPresent(Component.class)){
            //��ȡ���ϵ�ע��
            Component annotation = aClass.getAnnotation(Component.class);
            System.out.println(annotation.value());
        }

    }

}
