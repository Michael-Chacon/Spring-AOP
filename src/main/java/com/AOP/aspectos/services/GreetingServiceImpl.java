package com.AOP.aspectos.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{
    @Override
    public String sayHello(String person, String message) {
        String greeting = message + " " + person;
        System.out.println(greeting);
        return greeting;
    }

    @Override
    public String sayHelloError() {
        throw new RuntimeException("ERROR para probar el @AfterThrowing");
    }
}
