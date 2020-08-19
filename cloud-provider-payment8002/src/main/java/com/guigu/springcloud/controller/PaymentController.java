package com.guigu.springcloud.controller;

import com.guigu.springcloud.entities.CommonResult;
import com.guigu.springcloud.entities.Payment;
import com.guigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverpost;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***************插入结果        "+result);
        if(result >0){
            return new CommonResult(200,"插入数据库成功,serverpost: "+serverpost,result);
        }else{
            return new CommonResult(500,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("****************查询结果        "+result+"   哈哈哈"+"    111"+"2222"+"3333");
        if(result != null){
            return new CommonResult(200,"查询成功,serverpost: "+serverpost,result);
        }else{
            return new CommonResult(500,"没有对应记录: "+id,null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverpost;
    }
}
