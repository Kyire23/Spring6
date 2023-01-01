package com.oumuanode.spring6.test;

import com.oumuanode.spring6.bean.Husband;
import com.oumuanode.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testCircular(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husband = applicationContext.getBean("h",Husband.class);
        System.out.println(husband);

        Wife wife = applicationContext.getBean("w",Wife.class);
        System.out.println(wife);
    }
}
