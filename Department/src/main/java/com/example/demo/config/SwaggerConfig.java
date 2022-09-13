package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration   // so spring boot will uinderstand that this file is a configuration where all properties are set 
                 //configurattion file is njust like a application properties

@EnableSwagger2   // used to enable the swagger on the application
public class SwaggerConfig {
	
	
	@Bean         //create an object
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.example.demo"))
			.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Department Services ").description(
				"Elearning is an android app  used by the Education team for assessment of VMware customer's employees skill level with the intent of recommending specific VMware courses according to the customer outcomes, goals and each employees skill level need in their roles.\n")
				.contact(new Contact("Twinkle Shah", "www.twinkle.in", "twinkle.shah@nimap.co.in"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}	

}
