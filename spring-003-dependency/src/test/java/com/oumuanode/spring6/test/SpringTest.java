package com.oumuanode.spring6.test;

import com.oumuanode.spring6.bean.Person;
import com.oumuanode.spring6.bean.SimpleValueType;
import com.oumuanode.spring6.bean.User;
import com.oumuanode.spring6.service.CustomerService;
import com.oumuanode.spring6.service.OrderService;
import com.oumuanode.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testAutoWire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_autowire.xml");
//        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
//        orderService.generate();
            CustomerService customerService = applicationContext.getBean("cs",CustomerService.class);
            customerService.save();

    }

    @Test
    public void testCollection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Person person = applicationContext.getBean("personBean",Person.class);
        System.out.println(person);
    }
    @Test
    public void testSimpleTypeSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        SimpleValueType svt = applicationContext.getBean("svt", SimpleValueType.class);
        System.out.println(svt);
    }
    @Test
    public void testSetDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderService.generate();
    }


    @Test
    public void testSetID(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userServiceBean",UserService.class);
        userService.saveService();
    }

    @Test
    public void testConstructorDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("csBean",CustomerService.class);
        customerService.save();
    }
}
