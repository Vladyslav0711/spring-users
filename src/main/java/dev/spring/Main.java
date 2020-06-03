package dev.spring;

import dev.spring.config.AppConfig;
import dev.spring.model.User;
import dev.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Vlad", "123"));
        userService.add(new User("Ola", "111"));
        userService.add(new User("Dima", "222"));

        userService.listUsers().forEach(System.out::println);
    }
}
