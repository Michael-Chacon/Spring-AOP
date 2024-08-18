package com.AOP.aspectos.controllers;

import com.AOP.aspectos.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService service;

    @GetMapping("/greeting")
    public ResponseEntity<?> saludar(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", service.sayHello("Mari", ":) Hola")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> saludarError(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", service.sayHelloError()));
    }
}
