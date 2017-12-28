package com.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.boot.interceptor.MyInterceptor;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

	/**
	 * 配置静态访问资源
	 * 
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
		super.addResourceHandlers(registry);
	}
	// http://localhost:9090/public/a.jpg
	// 通过addResourceHandler添加映射路径，然后通过addResourceLocations来指定路径。我们访问自定义my文件夹中的elephant.jpg
	// 图片的地址为 http://localhost:8080/my/elephant.jpg

	/**
	 * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
	 * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.jsp页面了
	 * 
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/toLogin").setViewName("login");
		super.addViewControllers(registry);
	}
	
	
    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
        super.addInterceptors(registry);
}
}