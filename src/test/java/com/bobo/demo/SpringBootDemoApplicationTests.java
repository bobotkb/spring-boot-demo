package com.bobo.demo;

import com.bobo.demo.configuration.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Autowired
    @Qualifier("person1")
    private Person person1;

    @Autowired
    @Qualifier("person2")
    private Person person2;

    @Test
    void contextLoads() {
        System.out.println(person1);
        System.out.println(person2);
    }

}
