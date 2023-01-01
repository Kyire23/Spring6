package com.oumuanode.spring6.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpringCode(){
        //第一步 获取Spring容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        //记录日志  级别根据xml 类型来调
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        logger.info("我是一条信息");
        logger.debug("我是一条调试信息");
        logger.error("我是一条错误信息");
        //根据id 获取对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        Object nowTime = applicationContext.getBean("nowTime");
        System.out.println(nowTime);
    }
}
