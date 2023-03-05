package com.example.bootexitcode;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.lang.model.type.UnknownTypeException;

@SpringBootApplication
public class BootExitcodeApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(BootExitcodeApplication.class, args);
		try {
			System.out.println("try block");
		} finally {
			System.exit(SpringApplication.exit(context));
		}
	}
	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
     return() -> {
		return 1000;
	 };
	}

//	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			throw new UnknownError("initialization failed");
		};
	}

	@Bean
	public ExitCodeExceptionMapper exitCodeExceptionMapper() {

		return new ExitCodeExceptionMapper() {
			@Override
			public int getExitCode(Throwable exception) {
//				Throwable cause = exception.getCause();
				if (exception instanceof UnknownError) {
					return -111;
				}
				return 1;
			}
		};
	}

	@Bean
	public ApplicationListener<ExitCodeEvent> exitCodeEventApplicationListener() {
      return (e) -> {
		System.out.println(e.getExitCode());
	  };
	}

}
