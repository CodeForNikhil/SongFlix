package com.songlyrics.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	
	@Bean
	public WebMvcConfigurer CorsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry reg) {
				reg.addMapping("/**")
				.allowedHeaders("Access-Control-Allow-Origin")
				.allowedMethods("*")
				.allowedOrigins("http://localhost:3000");
			}
		};
	}

}
