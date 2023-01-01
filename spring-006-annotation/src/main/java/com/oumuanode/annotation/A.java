package com.oumuanode.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//Ñ¡Ôñ ÊµÀý»¯ ²âÊÔ
@Component
public class A {
    public A() {
        System.out.println("A");
    }
}

@Controller
class B{
    public B(){
        System.out.println("B");

    }
}

@Service
class C{
    public C() {
        System.out.println("C");

    }
}

@Repository
class D{
    public D() {
        System.out.println("D");

    }
}