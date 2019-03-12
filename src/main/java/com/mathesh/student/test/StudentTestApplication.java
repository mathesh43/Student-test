package com.mathesh.student.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mathesh.student.test.Service.QuestionAndAnswerService;
import com.sendgrid.SendGrid;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
@PropertySource("classpath:application.yml")
public class StudentTestApplication {

    @Value("${sendgrid.api.key}")
    private String sendGridAPIKey;
    
    public static void main(String[] args) {
		SpringApplication.run(StudentTestApplication.class, args);
	}

	
	@Bean
	public QuestionAndAnswerService questionAndAnswerService (QuestionAndAnswerService questionAndAnswerService) {
	    questionAndAnswerService.createDefaultQuestions();
	    return questionAndAnswerService;
	}
	
	
    @Bean
    public SendGrid sendGrid () {
        return new SendGrid(sendGridAPIKey);
    }
	
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
	    InternalResourceViewResolver resolver= new InternalResourceViewResolver();
	    resolver.setPrefix("/");
	    resolver.setSuffix(".html");
	    return resolver;
	}  

}
