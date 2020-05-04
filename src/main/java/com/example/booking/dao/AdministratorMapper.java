package com.example.booking.dao;

import com.example.booking.bean.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdministratorMapper {

    Administrator getAdministrator(Integer id);

    Administrator getAdministratorByEmail(String email);

    void saveAdministrator(Administrator administrator);

}
