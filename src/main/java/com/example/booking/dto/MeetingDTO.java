package com.example.booking.dto;

import com.example.booking.bean.Meeting;
import com.example.booking.bean.MeetingRoom;

import java.util.List;

public class MeetingDTO {

    private int code;

    private String msg;

    private int count;

    private List<Meeting> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Meeting> getData() {
        return data;
    }

    public void setData(List<Meeting> data) {
        this.data = data;
    }
}
