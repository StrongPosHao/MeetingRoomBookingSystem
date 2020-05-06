package com.example.booking.controller;

import com.example.booking.bean.User;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        User user = userService.userLogin(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/index";
        } else {
            map.put("msg", "Password is not correct!");
            return "login";
        }
    }

    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/user/register")
    public String register() {
        return "register";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/user/login";
    }

    @GetMapping("/user/meeting")
    public String userMeeting() {
        return "user-meeting";
    }

}
