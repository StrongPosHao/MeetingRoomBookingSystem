package com.example.booking.dao;

import com.example.booking.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User getUerById(Integer id);

    User getUserByEmail(String email);

    void saveUser(User user);
}
