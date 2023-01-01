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
        //需求 只知道包名 有注解 实例化对象
        String packageName = "com.oumuanode.bean";
        String packagePath = packageName.replaceAll("\\.", "/");
        System.out.println(packagePath);

        //com 是在类的根路径下的目录
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();
//        System.out.println(path);

//        获取一个绝对路径下的所有文件
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
                    //获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    //创建对象
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
