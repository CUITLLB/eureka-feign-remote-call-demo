package cn.cuit.product.center.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 将自己作为一个可以被Eureka Server发现注册的Client
@EnableDiscoveryClient
// 将自己作为一个可以被其他服务通过Feign调用的Client
@EnableFeignClients
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
