package com.guigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface Balanced {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
