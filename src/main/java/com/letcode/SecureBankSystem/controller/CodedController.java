package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.bo.Contact;
import com.letcode.SecureBankSystem.bo.FarewellRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class CodedController {
    public List<Contact> contact = new ArrayList<>();


    @GetMapping("/sayHi")
    public String sayHi() {
        return "welcome to Coded";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name;
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody FarewellRequest farewellRequest) {
        String name = farewellRequest.getName();
        return "Goodbye, " + name;
    }

    @PostMapping("/addContact")
    public String addContact(@RequestBody Contact contacts) {
        for (Contact exitsContact : contact) {
            if (exitsContact.getEmail().equals(contacts.getEmail())) {
                return "email already exists";
            }
        }
        contact.add(contacts);
        return "contact added successfully "+contacts.getName()+ "\n"+ contacts.getEmail()+"\n"+contacts.getPhone();
    }


    @GetMapping("/contactDetails")
    public String contactDetails(@RequestParam String name) {
        for (Contact contact : contact) {
            if (contact.getName().equals(name)) {
                return "Name: " + contact.getName() + "\nEmail: " + contact.getEmail() + "\nphone: " + contact.getPhone();
            }
        }
        return "contact not found";
    }
}