package com.yuqing;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    void nacosDiscovery() throws NacosException {
        for (String service : nacosServiceDiscovery.getServices()) {
            System.out.println("service:" + service);
            //获取ip和端口
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("instance:" + instance.getHost() + "\t" + "port=" + instance.getPort() + "\t" + instance.getUri());
            }
        }
    }

    @Test
    void discoveryClientTest() {
        for (String service : discoveryClient.getServices()) {
            System.out.println("service:" + service);
            //获取ip和端口
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("instance:" + instance.getHost() + "\t" + "port=" + instance.getPort() + "\t" + instance.getUri());
            }
        }

    }
}
