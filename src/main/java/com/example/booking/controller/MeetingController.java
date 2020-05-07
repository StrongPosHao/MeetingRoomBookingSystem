package com.example.booking.controller;

import com.example.booking.bean.Meeting;
import com.example.booking.dto.MeetingDTO;
import com.example.booking.service.MeetingService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @PostMapping("/meeting")
    @ResponseBody
    public void addMeeting(Meeting meeting) {
        System.out.println(meeting);
        meetingService.addMeeting(meeting);
    }

    @GetMapping("/meeting/{userId}")
    @ResponseBody
    public MeetingDTO getMeeting(@PathVariable int userId,
                             @RequestParam("page") String page,
                             @RequestParam("limit") String limit) {
        PageInfo<Meeting> pageInfo = meetingService.getUserMeeting(userId, Integer.parseInt(page), Integer.parseInt(limit));
        MeetingDTO msg = new MeetingDTO();
        msg.setCode(0);
        msg.setMsg("succeed");
        msg.setCount((int) pageInfo.getTotal());
        msg.setData(pageInfo.getList());
        return msg;
    }

    @DeleteMapping("/meeting/{id}")
    @ResponseBody
    public void deleteMeeting(@PathVariable("id") int id) {
        meetingService.deleteMeeting(id);
    }

    @PutMapping("/meeting/{id}")
    @ResponseBody
    public void modifyMeeting(Meeting meeting) {
        meetingService.modifyMeeting(meeting);
    }


}
