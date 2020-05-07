package com.example.booking.dao;

import com.example.booking.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User getUerById(Integer id);

    User getUserByEmail(String email);

    void saveUser(User user);

    void updateUser(User user);

    List<User> getUsers();

    void deleteUser(User user);
}
