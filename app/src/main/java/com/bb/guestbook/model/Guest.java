package com.bb.guestbook.model;

public class Guest {

    private String fullName;
    private String roomNumber;


    public Guest(String fullName, String roomNumber) {
        this.fullName = fullName;
        this.roomNumber = roomNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
