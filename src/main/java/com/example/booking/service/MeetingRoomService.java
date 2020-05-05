package com.example.booking.service;

import com.example.booking.bean.Meeting;
import com.example.booking.bean.MeetingRoom;
import com.example.booking.dao.MeetingRoomMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MeetingRoomService {

    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    public List<MeetingRoom> getAll() {
        return meetingRoomMapper.getAllMeetingRooms();
    }

    public PageInfo<MeetingRoom> getMeetingRoomByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "room_number asc");
        List<MeetingRoom> rooms = meetingRoomMapper.getAllMeetingRooms();
        Collections.sort(rooms);
        return new PageInfo<MeetingRoom>(rooms);
    }

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoomMapper.saveMeetingRoom(meetingRoom);
    }

    public void deleteMeetingRoom(String roomNumber) {
        meetingRoomMapper.deleteMeetingRoom(roomNumber);
    }


}
