package com.sword.feat.service;

import org.springframework.stereotype.Service;

import com.sword.feat.model.User;

@Service
public interface UserService {

    User registerUser(User user);
}
