package com.example.booking.controller;

import com.example.booking.bean.User;
import com.example.booking.dto.UserDTO;
import com.example.booking.service.UserService;
import com.github.pagehelper.PageInfo;
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

    @GetMapping("/user/register")
    public String register() {
        return "register";
    }

    @PostMapping("/user/register")
    public String register(@RequestParam("userName") String userName,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("confirm") String confirm,
                           Map<String, Object> map, HttpSession session) {
        if (!password.equals(confirm)) {
            map.put("msg", "Two input password is not same!");
            return "register";
        }
        User user = new User(userName, password, email);
        userService.addUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/user/profile")
    public String profile() {
        return "profile";
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    public void updateUser(User user, HttpSession session) {
        User updatedUser = userService.updateUser(user);
        session.setAttribute("user", updatedUser);
    }

    @DeleteMapping("/admin/user/{id}")
    @ResponseBody
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }

    @RequestMapping("/users")
    @ResponseBody
    public UserDTO adminGetUsers(@RequestParam("page")String page, @RequestParam("limit") String limit, HttpSession session) {
        PageInfo<User> pageInfo = userService.getUsers(Integer.parseInt(page), Integer.parseInt(limit));
        UserDTO msg = new UserDTO();
        msg.setCode(0);
        msg.setMsg("succeed");
        msg.setCount((int) pageInfo.getTotal());
        msg.setData(pageInfo.getList());
        return msg;
    }

}
