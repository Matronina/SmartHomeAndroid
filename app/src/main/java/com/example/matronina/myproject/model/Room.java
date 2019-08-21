package com.example.matronina.myproject.model;

public class Room {
    public static final String TABLE_NAME = "Room";
    public static final String COLUMN_ID = "id_room";
    public static final String COLUMN_NAME_ROOM = "name_room";
    public static final String COLUMN_NAME_IMG = "img_name";

    public static final int KITCHEN_ID      = 1;
    public static final int BEDROOM_ID      = 2;
    public static final int BATHROOM_ID     = 3;
    public static final int LIVING_ROOM_ID  = 4;
    public static final int DINING_ROOM_ID  = 5;

    final private String nameRoom;
    final private String imgName;
    final private int idRoom;

    public Room(int idRoom, String nameRoom, String imgName) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.imgName = imgName;

    }

    public String GetRoomName() { return nameRoom; }
    public String GetImgName() { return imgName; }
    public int GetRoomId() { return idRoom; }
}
