package com.example.booking.dao;

import com.example.booking.bean.MeetingRoom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MeetingRoomMapper {

    MeetingRoom getMeetingRoom(int roomNumber);

    void saveMeetingRoom(MeetingRoom meetingRoom);

    List<MeetingRoom> getAllMeetingRooms();

    void deleteMeetingRoom(int roomNumber);

    void updateMeetingRoom(MeetingRoom meetingRoom);

}
