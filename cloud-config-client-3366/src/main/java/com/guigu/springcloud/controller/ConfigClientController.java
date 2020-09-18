package com.guigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${server.port}")
    private String servicePort;
    @Value("${config.info}")
    private String configInfo;

    public String configInfo(){
        return "serverPort:"+servicePort+"\t\n\n configInfo: "+configInfo;
    }
}
