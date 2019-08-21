package com.example.matronina.myproject.model;

public final class Lights {
    public static final String TABLE_NAME = "Light";
    public static final String COLUMN_ID = "id_light";
    public static final String COLUMN_ROOM_NAME = "name_room";
    public static final String COLUMN_SET_LIGHT = "sett_on_off_light";

    final private int roomID;
    final private String roomName;
    private boolean status;

    public Lights(int roomID, String roomName, boolean status) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.status = status;
    }

    public int GetRoomID() { return roomID; }
    public String GetRoomName() { return roomName; }
    public boolean GetStatus() { return status; }
    public void SetStatus(boolean val) { status = val; }
}
