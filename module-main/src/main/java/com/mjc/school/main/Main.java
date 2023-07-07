package com.mjc.school.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaAuditing
public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        Menu menu = context.getBean(Menu.class);
        menu.mainController();
    }
}
