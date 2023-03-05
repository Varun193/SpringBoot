package com.example.bootprofiles;

import com.example.bootprofiles.beans.CustomYamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:testprop.yml", factory = CustomYamlPropertySourceFactory.class)
@Profile("test")
public class TestConfig {


}
