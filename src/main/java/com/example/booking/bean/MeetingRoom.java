package com.example.booking.bean;


public class MeetingRoom implements Comparable<MeetingRoom> {

    private int roomNumber;

    private int capacities;

    private double price;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
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

    @Override
    public int compareTo(MeetingRoom o) {
        return this.roomNumber - o.roomNumber;
    }
}
