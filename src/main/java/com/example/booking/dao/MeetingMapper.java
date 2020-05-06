package com.example.booking.dao;

import com.example.booking.bean.Meeting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MeetingMapper {

    Meeting getMeeting(Integer id);

    void saveMeeting(Meeting meeting);

    List<Meeting> getMeetingByUserId(int userId);
}
