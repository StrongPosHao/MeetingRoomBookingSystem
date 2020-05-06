package com.example.booking.service;

import com.example.booking.bean.Meeting;
import com.example.booking.dao.MeetingMapper;
import com.example.booking.dao.MeetingRoomMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    MeetingMapper meetingMapper;

    public void addMeeting(Meeting meeting) {
        meetingMapper.saveMeeting(meeting);
    }

    public PageInfo<Meeting> getUserMeeting(int userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "id asc");
        List<Meeting> meetings = meetingMapper.getMeetingByUserId(userId);
//        PageInfo<Meeting> userMeetings =  meetingMapper.getMeetingByUserId(userId);
        return new PageInfo<>(meetings);
    }
}
