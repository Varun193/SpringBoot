package com.example.bootprofiles;

import com.example.bootprofiles.beans.CustomYamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:devprop.yml", factory = CustomYamlPropertySourceFactory.class)
@Profile("dev")
public class DevConfig {

}
