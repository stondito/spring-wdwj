package com.example.projectspring;


import com.example.projectspring.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(value = {AppConfig.class})
public class ProjectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringApplication.class, args);
	}

//	@Bean
//	ApplicationRunner applicationRunner(AppConfig appConfig) {
//		return args -> {
//			System.out.println(appConfig.getTest());
//			System.out.println(appConfig.getLc().getLv());
//		};
//	}

}
