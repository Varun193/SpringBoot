package com.example.bootcustomconfiguration;

import com.example.bootcustomconfiguration.entites.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:custom.properties")
@PropertySource("classpath:custom.yml")
public class BootCustomConfigurationApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BootCustomConfigurationApplication.class, args);
		Student student = context.getBean("student", Student.class);
		System.out.println(student.getId());
	}

}
