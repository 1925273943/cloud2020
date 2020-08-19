package com.guigu.springcloud.test;

import com.guigu.springcloud.dao.PaymentDao;
import com.guigu.springcloud.entities.Payment;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Resource
    PaymentDao paymentDao;
    @org.junit.Test
    public void doTest() {
        Payment p = new Payment();
        p.setSerial("aaa");
        Integer a = paymentDao.create(p);
        System.out.println(p.getId());
    }
}