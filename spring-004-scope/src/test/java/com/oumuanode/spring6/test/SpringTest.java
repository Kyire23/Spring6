package com.oumuanode.spring6.test;

import com.oumuanode.spring6.bean.SpringBean;
import com.oumuanode.spring6.bean.Star;
import com.oumuanode.spring6.bean.StarFactory;
import com.oumuanode.spring6.bean.Student;
import com.oumuanode.spring6.factory.Gun;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testDate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testBeanStart3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
        System.out.println(gun);
    }
    @Test
    public void testBeanStart(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        Star star = applicationContext.getBean("startBean", Star.class);
        System.out.println(star);
    }

    @Test
    public void testBeanScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb",SpringBean.class);
        System.out.println(sb);

        SpringBean sb2 = applicationContext.getBean("sb",SpringBean.class);
        System.out.println(sb2);

        SpringBean sb3 = applicationContext.getBean("sb",SpringBean.class);
        System.out.println(sb3);
    }
}
