package ru.easyum.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Объект контекст-приложения
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWorld);
        System.out.println(helloWorld.printMe());

    }
}
