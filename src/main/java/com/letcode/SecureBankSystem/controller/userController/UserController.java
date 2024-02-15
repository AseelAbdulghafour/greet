package com.letcode.SecureBankSystem.controller.userController;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserStatusRequest;
import com.letcode.SecureBankSystem.service.suggestions.GuestSuggestionService;
import com.letcode.SecureBankSystem.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService; //injection this is the constructor with similar class name

    private final GuestSuggestionService suggestionService;

    public UserController(UserService userService, GuestSuggestionService suggestionService) {
        this.userService = userService;
        this.suggestionService = suggestionService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            userService.saveUser(createUserRequest);


        }catch (IllegalArgumentException e){
//            System.out.println("Error please write ACTIVE or INACTIVE");
            return ResponseEntity.badRequest().body("Status should be written either ACTIVE or INACTIVE");
        }
        //userService.saveUser(createUserRequest);
        return ResponseEntity.ok("A User Has Been Created");
    }
    @PutMapping("/update")

    public  ResponseEntity<String>updateUser(@RequestParam Long userId,@RequestBody UpdateUserStatusRequest updateUserStatusRequest){
        try {
            userService.updateUserStatus(userId, updateUserStatusRequest);


        }catch (IllegalArgumentException e){
//            System.out.println("Error please write ACTIVE or INACTIVE");
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("A User Has Been Updated");
    }
}