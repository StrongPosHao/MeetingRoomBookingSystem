package com.example.booking.service;

import com.example.booking.bean.Administrator;
import com.example.booking.dao.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    AdministratorMapper administratorMapper;

    public Administrator adminLogin(String email, String password) {
        Administrator admin = administratorMapper.getAdministratorByEmail(email);
        if (admin != null && password.equals((admin.getPassword()))) {
            return admin;
        }
        return null;
    }


}
