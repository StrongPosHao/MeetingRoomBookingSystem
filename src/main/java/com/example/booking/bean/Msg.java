package com.example.booking.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Msg {

    private int code;

    private String msg;

    private int count;

    private List<MeetingRoom> data;

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

    public List<MeetingRoom> getData() {
        return data;
    }

    public void setData(List<MeetingRoom> data) {
        this.data = data;
    }
}
