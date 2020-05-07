package com.example.booking.service;

import com.example.booking.bean.User;
import com.example.booking.dao.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public void addUser(User user) {
        userMapper.saveUser(user);
    }

    public User updateUser(User user) {
        userMapper.updateUser(user);
        User user1 = userMapper.getUserByEmail(user.getEmail());
        return user1;
    }

    public PageInfo<User> getUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "id asc");
        List<User> users = userMapper.getUsers();
        return new PageInfo<>(users);
    }

    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }
}
