package com.guigu.springcloud.controller;

import com.guigu.springcloud.entities.CommonResult;
import com.guigu.springcloud.entities.Payment;
import com.guigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;
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
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //获取所有的在Eureka上注册的实例
        List<String> services = discoveryClient.getServices();
        for(String element : services){
            log.info("*******element"+element);
            List<ServiceInstance> instances = discoveryClient.getInstances(element);
            for(ServiceInstance serviceInstance:instances){
                log.info("某个服务下的实例信息  "+serviceInstance.getInstanceId()+"  "+serviceInstance.getServiceId()+"  "+serviceInstance.getPort()+"  "+serviceInstance.getServiceId()+"  "+serviceInstance.getUri());
            }
        }
        //获取某个实例下的所有服务信息
        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverpost;
    }

    /**
     * 测试OpenFeing超时
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeingTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverpost;
    }
}
