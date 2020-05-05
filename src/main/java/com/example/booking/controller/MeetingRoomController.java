package com.example.booking.controller;

import com.example.booking.bean.MeetingRoom;
import com.example.booking.bean.Msg;
import com.example.booking.service.MeetingRoomService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @RequestMapping("/rooms")
    @ResponseBody
    public Msg getRooms(@RequestParam("page") String page, @RequestParam("limit") String limit) {
        PageInfo<MeetingRoom> rooms = meetingRoomService.getMeetingRoomByPage(Integer.parseInt(page),
                Integer.parseInt(limit));
        Msg msg = new Msg();
        msg.setCode(0);
        msg.setMsg("succeed");
        msg.setCount((int) rooms.getTotal());
        msg.setData(rooms.getList());
        return msg;
    }

    @PostMapping("/room")
    @ResponseBody
    public void addRoom(MeetingRoom meetingRoom) {
        meetingRoomService.addMeetingRoom(meetingRoom);
    }

    @DeleteMapping("/room/{roomNumber}")
    @ResponseBody
    public void deleteRoom(@PathVariable("roomNumber") String roomNumber) {
        meetingRoomService.deleteMeetingRoom(roomNumber);
    }


}
