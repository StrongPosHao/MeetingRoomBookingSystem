package com.example.booking.dao;

import com.example.booking.bean.Meeting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MeetingMapper {

    Meeting getMeeting(Integer id);

    void saveMeeting(Meeting meeting);

}
