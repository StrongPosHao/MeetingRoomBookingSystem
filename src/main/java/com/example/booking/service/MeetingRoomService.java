package com.example.booking.service;

import com.example.booking.bean.MeetingRoom;
import com.example.booking.dao.MeetingRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {

    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    public List<MeetingRoom> getAll() {
        return meetingRoomMapper.getAllMeetingRooms();
    }

}
