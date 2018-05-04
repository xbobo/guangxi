package com.huishu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.huishu")
@EntityScan("com.huishu.bean")
@EnableJpaRepositories(basePackages = "com.huishu.repository")
@SpringBootApplication
@EnableCaching
public class Application {
	 public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
