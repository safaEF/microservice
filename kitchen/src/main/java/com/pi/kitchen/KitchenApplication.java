package com.pi.kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
public class KitchenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchenApplication.class, args);
	}

}
