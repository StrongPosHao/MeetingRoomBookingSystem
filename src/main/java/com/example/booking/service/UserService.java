package com.example.booking.service;

import com.example.booking.bean.User;
import com.example.booking.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User userLogin(String email, String password) {
        User user = userMapper.getUserByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }


}
