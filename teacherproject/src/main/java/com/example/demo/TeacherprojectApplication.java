package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.AuditAwareImpl;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class TeacherprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherprojectApplication.class, args);
	}
	
	  @Bean
	    public AuditorAware<String> auditorAware(){
	        return new AuditAwareImpl();
	    }

	  @Bean
	  public RestTemplate restTemplate() {
	   return new RestTemplate();
	  }
}
