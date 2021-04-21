package com.bobo.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bobo
 * @date 2021-04-22 0:22
 */
@Configuration
public class PersonConfigurationProperties {

    @Bean
    @ConfigurationProperties(prefix = "person")
    public Person person1() {
        return new Person();
    }

    @Bean
    @ConfigurationProperties(prefix = "info")
    public Person person2() {
        return new Person();
    }
}
