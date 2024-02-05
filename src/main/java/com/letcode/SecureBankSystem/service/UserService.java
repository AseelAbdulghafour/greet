package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;

public interface UserService {
    void saveUser(CreateUserRequest creatUserRequest);

    void status(String status);
}
