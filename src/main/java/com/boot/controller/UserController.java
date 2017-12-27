package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.ConfigBean;

@RestController
public class UserController {

	@Autowired
	ConfigBean configBean;

	@RequestMapping("/")
	public String hexo() {
		return configBean.getName() + "test" + configBean.getWant();
	}
}