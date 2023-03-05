package com.example.bootprofiles;

import com.example.bootprofiles.beans.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DevConfig.class, TestConfig.class})
public class BootProfilesApplication {

	public static void main(String[] args) {

//		ApplicationContext context = SpringApplication.run(BootProfilesApplication.class, args);
		SpringApplication application = new SpringApplicationBuilder().sources(BootProfilesApplication.class)
				.profiles("dev")
				.build();
		ApplicationContext context = application.run(args);
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
	}

}
