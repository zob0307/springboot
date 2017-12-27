package com.boot.chapter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

import com.boot.chapter2.sub.ConfigBean;

@SpringBootApplication
@RestController
@EnableConfigurationProperties({ ConfigBean.class })
public class Chapter2Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter2Application.class, args);
	}
}
