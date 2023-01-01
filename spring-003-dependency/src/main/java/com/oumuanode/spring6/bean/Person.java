package com.oumuanode.spring6.bean;

import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Person {
    //×¢ÈëList Set ¼¯ºÏ
    private List<String> names;

    private Set<String> addrs;

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addrs=" + addrs +
                ", properties=" + properties +
                '}';
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }
}
