package com.oumuanode.spring6.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpringCode(){
        //��һ�� ��ȡSpring��������
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        //��¼��־  �������xml ��������
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        logger.info("����һ����Ϣ");
        logger.debug("����һ��������Ϣ");
        logger.error("����һ��������Ϣ");
        //����id ��ȡ����
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        Object nowTime = applicationContext.getBean("nowTime");
        System.out.println(nowTime);
    }
}
