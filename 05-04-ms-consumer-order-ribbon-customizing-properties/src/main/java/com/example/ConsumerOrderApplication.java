package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerOrderApplication {
    /*
        定制Ribbon, 最方便用法,属性配置

        microservice-provider-user:
          ribbon:
            NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
     */

    @Bean
    @LoadBalanced //ribbon的负载均衡注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class, args);
    }

}
