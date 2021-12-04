package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.example.service.fileReader.FileReaderService;
import com.example.service.fileReader.FileReaderServiceImpl;

@Configuration
public class DemoConfiguration {
	
	@Bean
	FileReaderService fileReaderServiceImpl() {
		return new FileReaderServiceImpl();
	}
	
	
	@Bean
	ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource
			= new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasename("ufn58l-messages");
		return messageSource;
	}
	
}
