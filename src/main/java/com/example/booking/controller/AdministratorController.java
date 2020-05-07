package com.example.booking.controller;


import com.example.booking.bean.Administrator;
import com.example.booking.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @PostMapping("/admin/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        Administrator admin = administratorService.adminLogin(email, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "redirect:/admin";
        } else {
            map.put("msg", "Password is not correct!");
            return "admin-login";
        }
    }

    @GetMapping("/admin/login")
    public String login() {
        return "admin-login";
    }

    @GetMapping("/admin/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/admin/login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/admin/new")
    public String newRoom() {
        return "new-room";
    }

    @GetMapping("/admin/users")
    public String adminUsers() {
        return "admin-user";
    }
}
