package com.letcode.SecureBankSystem.service.user;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserStatusRequest;

public interface UserService {
    void saveUser(CreateUserRequest creatUserRequest);

    void updateUserStatus(Long userID, UpdateUserStatusRequest updateUserStatusRequest);


    void status(String status);
}
