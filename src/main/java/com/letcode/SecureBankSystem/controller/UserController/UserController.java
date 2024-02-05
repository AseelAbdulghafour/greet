package com.letcode.SecureBankSystem.controller.UserController;

import com.letcode.SecureBankSystem.bo.Status;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
     @PostMapping("/create-user")
    public ResponseEntity<String> createUser(CreateUserRequest createUserRequest){
        userService.saveUser(createUserRequest);
        return ResponseEntity.ok("User created successfully");
     }

     @PostMapping("/updateStatus")
    public ResponseEntity<String> updateStatus(@RequestParam String status){
        userService.status(status);
        return ResponseEntity.ok("Status update successfully");
     }
}
