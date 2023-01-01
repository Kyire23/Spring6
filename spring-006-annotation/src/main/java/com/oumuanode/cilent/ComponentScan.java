package com.oumuanode.cilent;

import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static void main(String[] args) {
        Map<String, Object> beanMap = new HashMap<>();
        //���� ֻ֪������ ��ע�� ʵ��������
        String packageName = "com.oumuanode.bean";
        String packagePath = packageName.replaceAll("\\.", "/");
        System.out.println(packagePath);

        //com ������ĸ�·���µ�Ŀ¼
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();
//        System.out.println(path);

//        ��ȡһ������·���µ������ļ�
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> {
//            System.out.println(f.getName());
//            System.out.println(f.getName().split("\\.")[0]);

            try {
                String className = packageName + "." + f.getName().split("\\.")[0];
                System.out.println(className);
                Class<?> aClass = Class.forName(className);
                if (aClass.isAnnotationPresent(Component.class)) {
                    //��ȡע��
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    //��������
                    Object obj = aClass.newInstance();
                    beanMap.put(id, obj);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        });
        System.out.println(beanMap);
    }
}
