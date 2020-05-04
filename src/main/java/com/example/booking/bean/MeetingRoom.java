package com.example.booking.bean;


public class MeetingRoom {

    private String roomNumber;

    private int capacities;

    private double price;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacities() {
        return capacities;
    }

    public void setCapacities(int capacities) {
        this.capacities = capacities;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", capacities=" + capacities +
                ", price=" + price +
                '}';
    }
}
