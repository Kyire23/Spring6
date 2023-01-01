package com.oumuanode.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.oumuanode.service"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Config {
}
