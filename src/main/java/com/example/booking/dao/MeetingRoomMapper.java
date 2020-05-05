package com.example.booking.dao;

import com.example.booking.bean.MeetingRoom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MeetingRoomMapper {

    MeetingRoom getMeetingRoom(String roomNumber);

    void saveMeetingRoom(MeetingRoom meetingRoom);

    List<MeetingRoom> getAllMeetingRooms();

    void deleteMeetingRoom(String roomNumber);
}
