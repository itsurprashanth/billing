package com.billing.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.billing")
public class SpringContextConfiguration {

	 @Bean
     public ViewResolver viewreslover(){
    	 InternalResourceViewResolver viewReslover= new InternalResourceViewResolver();
    		viewReslover.setViewClass(JstlView.class);
    	 viewReslover.setPrefix("/WEB-INF/pages/");
    	 viewReslover.setSuffix(".jsp");
    	 return viewReslover;
     }
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
