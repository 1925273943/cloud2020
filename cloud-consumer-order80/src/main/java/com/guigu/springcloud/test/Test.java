package com.guigu.springcloud.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.applet.Main;

import java.util.concurrent.atomic.AtomicInteger;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    /* *
     *
     *  1.CAS 是什么
     *     比较并交换
     * @param []
     * @return void
     */
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        /* expect期待值     update 修改值*/
        /*
         * 在主物理内存中去取出数据   然后修改完成后  去和主物理内存中的值比较
         * 如果主物理内存中的数据变换了就不修改  如果没有主物理内存的值没人修改 就修改里面的值
         * */
//        atomicInteger.compareAndSet(5,2019);
        System.out.println("是否可以修改主物理内存中的数据     "+atomicInteger.compareAndSet(5, 2019)+"     current的数据"+atomicInteger.get());
//        atomicInteger.compareAndSet(5,2020);
        System.out.println("是否可以修改主物理内存中的数据     "+atomicInteger.compareAndSet(5, 2019)+"     current的数据"+atomicInteger.get());
    }
    @org.junit.Test
    public void atomicInteagerTest(){
        System.out.println(111);
    }
}
