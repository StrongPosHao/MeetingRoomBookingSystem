package com.example.booking.controller;

import com.example.booking.bean.MeetingRoom;
import com.example.booking.bean.Msg;
import com.example.booking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @RequestMapping("/table/rooms")
    @ResponseBody
    public Msg getRooms() {
        List<MeetingRoom> rooms = meetingRoomService.getAll();
        Msg msg = new Msg();
        msg.setCode(0);
        msg.setMsg("succeed");
        msg.setData(rooms);
        return msg;
    }

}
