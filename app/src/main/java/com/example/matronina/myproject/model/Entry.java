package com.example.matronina.myproject.model;

public class Entry {
    public static final String TABLE_NAME = "Entry";
    public static final String COLUMN_ID = "id_entry";
    public static final String COLUMN_NAME = "door_name";
    public static final String COLUMN_SET = "set_loc_unloc";

    final private int doorId;
    final private String doorName;
    private boolean locked;

    public Entry (int doorId, String doorName, boolean locked) {
        this.doorId = doorId;
        this.doorName = doorName;
        this.locked = locked;
    }

    public String GetDoorName() { return doorName; }
    public boolean GetLocStatus() { return locked; }
    public void SetLocStatus(boolean val) { locked = val; }
    public int GetDoorId() { return doorId; }
}
