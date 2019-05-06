package com.example.demo;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	RedissonClient redissonSentinel(){
		/**
		 * 支持单机，主从，哨兵，集群等模式
		 * 此为哨兵模式
		 */
		Config config = new Config();
		config.useSingleServer()
				.setAddress("redis://127.0.0.1:6379");
		return Redisson.create(config);
	}
}
