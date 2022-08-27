package com.test.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).build().apiInfo(apiInfo());
	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Test Spring boot").description(
				"The api used to test.")
				.license("@CopyRight 2022").licenseUrl("licenseUrl").termsOfServiceUrl("").version("V0.1")
				.contact(new Contact("Taoufik Tababi",
						"http:/http://localhost:8080/swagger-ui.html#/",
						"tabbabitawfic@gmail.com"))
				.build();
	}

}
