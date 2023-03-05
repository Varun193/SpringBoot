package com.example.bootapplicationproperties;

import com.example.bootapplicationproperties.entites.Agent;
import com.example.bootapplicationproperties.entites.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
//@EnableConfigurationProperties
public class BootApplicationPropertiesApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(BootApplicationPropertiesApplication.class, args);
		Student student = applicationContext.getBean("student", Student.class);
		System.out.println("student id " + student.getId());
		Agent agent = applicationContext.getBean("agent", Agent.class);
		System.out.println("agent id " + agent.getId());
	}

}
