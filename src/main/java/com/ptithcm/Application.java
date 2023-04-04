
package com.ptithcm;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
       
    @Bean
    public ModelMapper modelMapper() {
    	 ModelMapper modelMapper = new ModelMapper();
         modelMapper.getConfiguration().setFieldMatchingEnabled(true)
         .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
         .setMatchingStrategy(MatchingStrategies.STRICT);
         return modelMapper;
    }

}