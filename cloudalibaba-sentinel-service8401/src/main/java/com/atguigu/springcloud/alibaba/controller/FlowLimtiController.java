package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimtiController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
//        TimeUnit.MICROSECONDS.sleep(10000);
        return "testA";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName().toString()+"-----B");
        return "testB";
    }
    @GetMapping("/testD")
    public String testD() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
//        log.info("testD 测试RT");
        log.info("异常比例");
        int i =  1/0;
        return "testD";
    }

    @GetMapping("/testE")
    public String testE() throws InterruptedException {
        log.info("测试异常数");
        int i =  10/0;
        return "testE ---测试异常数";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String HoxKey(@PathVariable(value = "p1",required = false) String p1,
                            @PathVariable(value = "p2",required = false) String p2
    ) {
        return "HotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey";
    }
}
