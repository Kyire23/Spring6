package com.oumuanode.spring6.bean;

import java.util.Date;

public class Student {
    private Date brith;

    public void setBrith(Date brith) {
        this.brith = brith;
    }

    @Override
    public String toString() {
        return "Student{" +
                "brith=" + brith +
                '}';
    }
}
