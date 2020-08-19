package com.guigu.springcloud.lb;

import com.sun.javafx.font.directwrite.DWFactory;
import com.sun.media.sound.SoftSynthesizer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import rx.observables.SyncOnSubscribe;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用juc   cas + 加自旋锁原理实现一个ribbit轮询算法
 */
@Component
public class MyLB implements Balanced {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            //
            current = atomicInteger.get();
            //整形的最大值   Inteage.MAX_VALUE  可以得到  二十一亿四千七百四十八万三千六百四十七
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*********next:  "+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
