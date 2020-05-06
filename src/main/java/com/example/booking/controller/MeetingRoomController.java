package com.example.booking.controller;

import com.example.booking.bean.MeetingRoom;
import com.example.booking.dto.MeetingRoomDTO;
import com.example.booking.service.MeetingRoomService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @RequestMapping("/rooms")
    @ResponseBody
    public MeetingRoomDTO getRooms(@RequestParam("page") String page, @RequestParam("limit") String limit, HttpSession session) {
        PageInfo<MeetingRoom> pageInfo = meetingRoomService.getMeetingRoomByPage(Integer.parseInt(page),
                Integer.parseInt(limit));
        session.setAttribute("lastPage", pageInfo.getPages());
        MeetingRoomDTO msg = new MeetingRoomDTO();
        msg.setCode(0);
        msg.setMsg("succeed");
        msg.setCount((int) pageInfo.getTotal());
        msg.setData(pageInfo.getList());
        return msg;
    }

    @PostMapping("/room")
    @ResponseBody
    public void addRoom(MeetingRoom meetingRoom, HttpSession session) {
        meetingRoomService.addMeetingRoom(meetingRoom);
    }

    @DeleteMapping("/room/{roomNumber}")
    @ResponseBody
    public void deleteRoom(@PathVariable("roomNumber") int roomNumber) {
        meetingRoomService.deleteMeetingRoom(roomNumber);
    }

    @PutMapping("/room/{roomNumber}")
    @ResponseBody
    public void editRoom(MeetingRoom meetingRoom) {
        meetingRoomService.editMeetingRoom(meetingRoom);
    }


}
