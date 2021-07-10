package com.dubbo.consumer;

import com.dubbo.inter.GreetingsService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @Author: Richered
 * @Date: 2020/1/31 16:15
 * @Description: 测试Dubbo服务，其实是模仿消费者进行调用提供者
 */
public class TestDubbo {
    static GreetingsService service;

    @BeforeAll
    static void beforeAll() {
        //寻找本地zk
        String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

        //配置
        ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(GreetingsService.class);
        reference.setGeneric(true);
        service = reference.get();
        Object res = service.sayHi("shiyl");
    }

    //常规参数化
    @ParameterizedTest
    @ValueSource(strings = {"dubbo", "seveniruby", "hogwarts"})
    void sayHi(String name){
        String message = service.sayHi(name);
        System.out.println(message);
    }
}
