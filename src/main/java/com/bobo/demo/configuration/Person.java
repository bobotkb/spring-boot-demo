package com.bobo.demo.configuration;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @author bobo
 * @date 2021-04-21 23:13
 */
@Component
//@ConfigurationProperties(prefix = "person")
//@PropertySource(value = {"classpath:config/person.properties"})
@PropertySources(value = {
        @PropertySource(value = {"classpath:config/person.properties"}),
        @PropertySource(value = {"classpath:config/info.properties"})
})
@Data
public class Person {
    private String name;
    private Integer age;

    private String phone;
    private String email;
}
