package com.example.hellomundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloMundoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloMundoApplication.class, args);
        System.out.println("hello world");
    }

}
