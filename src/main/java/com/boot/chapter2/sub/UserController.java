package com.boot.chapter2.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	ConfigBean configBean;

	@RequestMapping("/")
	public String hexo() {
		return configBean.getName() + configBean.getWant();
	}
}