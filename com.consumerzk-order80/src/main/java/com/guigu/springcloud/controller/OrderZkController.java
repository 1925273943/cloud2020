package com.guigu.springcloud.controller;

import com.guigu.springcloud.entities.CommonResult;
import com.guigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZkController {
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String INVOKE_URL = "http://cloud-payment-service";
//    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

//    @GetMapping(value = "/consumer/payment/create")
//    public CommonResult<Payment> create(Payment payment){
//        return restTemplate.postForObject(INVOKE_URL+"/payment/create",payment,CommonResult.class);
//    }

    @GetMapping(value = "/consumer/payment/zk")
    public String getPayment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk", String.class);
    }
}
