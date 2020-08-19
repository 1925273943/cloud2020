package com.guigu.springcloud.test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest //它默认会为我们加载Spring容器，
public class TestDemo {

    @Test
    public void fun1(){
//        System.out.println(student.getName());
        System.out.println(111);
    }
}
