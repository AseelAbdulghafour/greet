package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.UserRepository;
import com.letcode.SecureBankSystem.service.admin.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AdminServiceImp implements AdminService {
    private final UserRepository userRepository;

    public AdminServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}