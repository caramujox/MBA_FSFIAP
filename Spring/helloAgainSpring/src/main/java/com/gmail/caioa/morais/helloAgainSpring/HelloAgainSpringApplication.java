package com.gmail.caioa.morais.helloAgainSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HelloAgainSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloAgainSpringApplication.class, args);
    }

}
