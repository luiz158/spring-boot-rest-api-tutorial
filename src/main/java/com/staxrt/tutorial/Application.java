package com.staxrt.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The type Application.
 *
 * @author Givantha Kalansuriya
 */
@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private Environment env;
  /**
   * The entry point of application.
   * @param args the input arguments
   */
  public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/products").allowedOrigins("http://localhost:8080");
            }
        };
    }

	@Override
	public void run(String... args )throws Exception {
        System.out.println("*########********* spring.datasource.url: "+env.getProperty("spring.datasource.url"));

        System.out.println("#############********** spring.datasource.username: "+env.getProperty("spring.datasource.username"));
        System.out.println("#############********** spring.datasource.password: "+env.getProperty("spring.datasource.password"));
    }
}
