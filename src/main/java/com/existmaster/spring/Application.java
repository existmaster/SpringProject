package com.existmaster.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by existmaster on 2015. 6. 18..
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        SpringApplication app= new SpringApplication(Application.class);
        app.run(args);

    }
}
