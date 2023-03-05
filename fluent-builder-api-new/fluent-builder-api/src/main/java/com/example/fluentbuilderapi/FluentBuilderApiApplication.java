package com.example.fluentbuilderapi;

import com.example.fluentbuilderapi.entites.Radio;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FluentBuilderApiApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplicationBuilder(FluentBuilderApiApplication.class).bannerMode(Banner.Mode.OFF).build(args);
		ApplicationContext context = application.run();
//	    ApplicationContext context = SpringApplication.run(FluentBuilderApiApplication.class, args);
		Radio bean = context.getBean("radio", Radio.class);
		bean.listen();

	}

}
