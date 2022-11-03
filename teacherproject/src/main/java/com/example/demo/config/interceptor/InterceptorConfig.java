package com.example.demo.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//import lombok.RequiredArgsConstructor;
//@RequiredArgsConstructor  // we can write RequiredArgsConstructor if we do not want to write autowired
@Component
public class InterceptorConfig extends WebMvcConfigurationSupport{
	
	//private final TeacherInterceptor interceptor = new UserInterceptor();
	
	@Autowired
	private  TeacherInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
    
}



