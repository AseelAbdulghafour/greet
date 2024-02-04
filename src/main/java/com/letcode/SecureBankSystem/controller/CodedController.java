package com.letcode.SecureBankSystem.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CodedController {

    @GetMapping("/sayHi")
    public String sayHi(){
        return "Welcome nada";
    }

    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", defaultValue = "world") String name){
        return "Hello, " + name + "!";
    }

    @PostMapping ("/farewell")
    public String farewell(@RequestBody Fields requestBodey){
        String name = requestBodey.getName();
        return "Goodbye, " + name + "!";
    }
}
