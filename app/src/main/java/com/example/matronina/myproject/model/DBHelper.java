package com.example.matronina.myproject.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper implements IDBHelper {

    private static final String TAG = DBHelper.class.getName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "my_db";

    private static final String SQL_CREATE_APPLIANCE_TABLE =
            "CREATE TABLE " + Appliance.TABLE_NAME + "("
            + Appliance.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + Appliance.COLUMN_NAME + " TEXT,"
            + Appliance.COLUMN_SET + " INTEGER"
            + ")";
    private static final String SQL_CREATE_ENTRY_TABLE =
            "CREATE TABLE " + Entry.TABLE_NAME + "("
            + Entry.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + Entry.COLUMN_NAME + " TEXT,"
            + Entry.COLUMN_SET + " INTEGER"
            + ")";
    private static final String SQL_CREATE_LIGHTS_TABLE =
            "CREATE TABLE " + Lights.TABLE_NAME + "("
            + Lights.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + Lights.COLUMN_ROOM_NAME + " TEXT,"
            + Lights.COLUMN_SET_LIGHT + " INTEGER"
            + ")";
    private static final String SQL_CREATE_ADMIN_TABLE =
            "CREATE TABLE " + Admin.TABLE_NAME + "("
            + Admin.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + Admin.COLUMN_DAY + " INTEGER,"
            + Admin.COLUMN_TYPE + " INTEGER,"
            + Admin.COLUMN_TIME_ON + " TEXT,"
            + Admin.COLUMN_TIME_OFF + " TEXT"
            + ")";
    private static final String SQL_CREATE_ROOMS_TABLE =
            "CREATE TABLE " + Room.TABLE_NAME + "("
            + Room.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + Room.COLUMN_NAME_ROOM + " TEXT,"
            + Room.COLUMN_NAME_IMG + " TEXT"
            + ")";
    private static final String SQL_CREATE_ALERT_TABLE =
            "CREATE TABLE " + Alert.TABLE_NAME + "("
            + Alert.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + Alert.COLUMN_TIME + " TEXT,"
            + Alert.COLUMN_TYPE + " TEXT,"
            + Alert.COLUMN_INDEX + " INTEGER"
            + ")";
    private static final String SQL_CREATE_TEMP_TABLE =
            "CREATE TABLE " + Temperature.TABLE_NAME + "("
            + Temperature.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + Temperature.COLUMN_NAME + " STRING,"
            + Temperature.COLUMN_DAY_TIME + " TEXT,"
            + Temperature.COLUMN_DAY_TEMP + " INTEGER,"
            + Temperature.COLUMN_NIGHT_TIME + " TEXT,"
            + Temperature.COLUMN_NIGHT_TEMP + " INTEGER"
            + ")";

    private SQLiteDatabase mDB;

    private static DBHelper sInstance = null;

    public static DBHelper GetInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBHelper(context);
        }
        return sInstance;
    }

    // DBHelper is a singleton, so making constructor private
    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating tables:
        db.execSQL(SQL_CREATE_APPLIANCE_TABLE);
        db.execSQL(SQL_CREATE_ENTRY_TABLE);
        db.execSQL(SQL_CREATE_LIGHTS_TABLE);
        db.execSQL(SQL_CREATE_ADMIN_TABLE);
        db.execSQL(SQL_CREATE_ROOMS_TABLE);
        db.execSQL(SQL_CREATE_ALERT_TABLE);
        db.execSQL(SQL_CREATE_TEMP_TABLE);

        // Populating DB with default data:
        db.execSQL("INSERT INTO " + Appliance.TABLE_NAME + " VALUES (1,'Refrigerator',1);");
        db.execSQL("INSERT INTO " + Appliance.TABLE_NAME + " VALUES (2,'Dishwasher',0);");
        db.execSQL("INSERT INTO " + Appliance.TABLE_NAME + " VALUES (3,'Oven',0);");
        db.execSQL("INSERT INTO " + Appliance.TABLE_NAME + " VALUES (4,'Cameras',0);");
        db.execSQL("INSERT INTO " + Appliance.TABLE_NAME + " VALUES (5,'Coffee Machine',0);");

        db.execSQL("INSERT INTO " + Entry.TABLE_NAME + " VALUES (1,'Front',1);");
        db.execSQL("INSERT INTO " + Entry.TABLE_NAME + " VALUES (2,'Back',0);");
        db.execSQL("INSERT INTO " + Entry.TABLE_NAME + " VALUES (3,'Garage',0);");

        db.execSQL("INSERT INTO " + Lights.TABLE_NAME + " VALUES (1,'Kitchen',1);");
        db.execSQL("INSERT INTO " + Lights.TABLE_NAME + " VALUES (2,'Bathroom',0);");
        db.execSQL("INSERT INTO " + Lights.TABLE_NAME + " VALUES (3,'Bedroom',0);");
        db.execSQL("INSERT INTO " + Lights.TABLE_NAME + " VALUES (4,'Living Room',1);");
        db.execSQL("INSERT INTO " + Lights.TABLE_NAME + " VALUES (5,'Dining Room',0);");

        db.execSQL("INSERT INTO " + Room.TABLE_NAME + " VALUES (1,'Kitchen','kitchen.png');");
        db.execSQL("INSERT INTO " + Room.TABLE_NAME + " VALUES (2,'Bedroom','bedroom.png');");
        db.execSQL("INSERT INTO " + Room.TABLE_NAME + " VALUES (3,'Bathroom','bathroom.png');");
        db.execSQL("INSERT INTO " + Room.TABLE_NAME + " VALUES (4,'Living Room','dining_room.png');");
        db.execSQL("INSERT INTO " + Room.TABLE_NAME + " VALUES (5,'Dining Room','living_room.png');");

        db.execSQL("INSERT INTO " + Temperature.TABLE_NAME
                + " VALUES (1,'Sunday','09:00',70,'20:00',65);");
        db.execSQL("INSERT INTO " + Temperature.TABLE_NAME
                + " VALUES (2,'Monday','09:00',70,'20:00',65);");
        db.execSQL("INSERT INTO " + Temperature.TABLE_NAME
                + " VALUES (3,'Tuesday','09:00',70,'20:00',65);");
        db.execSQL("INSERT INTO " + Temperature.TABLE_NAME
                + " VALUES (4,'Wednesday','09:00',70,'20:00',65);");
        db.execSQL("INSERT INTO " + Temperature.TABLE_NAME
                + " VALUES (5,'Thursday','09:00',70,'20:00',65);");
        db.execSQL("INSERT INTO " + Temperature.TABLE_NAME
                + " VALUES (6,'Friday','09:00',70,'20:00',65);");
        db.execSQL("INSERT INTO " + Temperature.TABLE_NAME
                + " VALUES (7,'Saturday','09:00',70,'20:00',65);");

        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (1,1,1,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (2,2,1,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (3,3,1,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (4,4,1,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (5,5,1,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (6,6,1,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (7,7,1,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (8,1,2,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (9,2,2,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (10,3,2,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (11,4,2,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (12,5,2,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (13,6,2,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (14,7,2,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (15,1,3,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (16,2,3,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (17,3,3,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (18,4,3,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (19,5,3,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (20,6,3,'06:00','20:00');");
        db.execSQL("INSERT INTO " + Admin.TABLE_NAME + " VALUES (21,7,3,'06:00','20:00');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Create tables again
        onCreate(db);
    }

   @Override
    public void SetTemperature(Temperature temp) {
        ContentValues values = new ContentValues();
        values.put(Temperature.COLUMN_ID, temp.GetDayID());
        values.put(Temperature.COLUMN_DAY_TIME, temp.GetDayTime().toString());
        values.put(Temperature.COLUMN_DAY_TEMP, temp.GetDayTemp());
        values.put(Temperature.COLUMN_NIGHT_TIME, temp.GetNightTime().toString());
        values.put(Temperature.COLUMN_NIGHT_TEMP, temp.GetNightTemp());
        mDB.replace(Temperature.TABLE_NAME, null, values);
    }

    public Temperature GetTemperature(int dayID) {
        String query = " SELECT * FROM " + Temperature.TABLE_NAME +
                " WHERE " + Temperature.COLUMN_ID + " = " + dayID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            String name = cursor.getString(cursor.getColumnIndex(Temperature.COLUMN_NAME));
            LocalTime dayTime = LocalTime.parse(
                    cursor.getString(cursor.getColumnIndex(Temperature.COLUMN_DAY_TIME)));
            LocalTime nightTime = LocalTime.parse(
                    cursor.getString(cursor.getColumnIndex(Temperature.COLUMN_NIGHT_TIME)));
            int dayTemp = cursor.getInt(cursor.getColumnIndex(Temperature.COLUMN_DAY_TEMP));
            int nightTemp = cursor.getInt(cursor.getColumnIndex(Temperature.COLUMN_NIGHT_TEMP));
            return new Temperature(dayID, name, dayTime, dayTemp, nightTime, nightTemp);
        } else {
            Log.e(TAG, "Temperature record not found for dayID: " + dayID);
        }
        return null;
    }

    @Override
    public void SetLights(Lights lights) {
        ContentValues values = new ContentValues();
        values.put(Lights.COLUMN_ID, lights.GetRoomID());
        values.put(Lights.COLUMN_ROOM_NAME, lights.GetRoomName());
        values.put(Lights.COLUMN_SET_LIGHT, lights.GetStatus());
        mDB.replace(Lights.TABLE_NAME, null, values);
    }

    @Override
    public List<Lights> GetLightsList() {
        List<Lights> res = new ArrayList<>();
        String query = "SELECT * FROM " + Lights.TABLE_NAME + " ORDER BY " + Lights.COLUMN_ID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(Lights.COLUMN_ID));
                String roomName = cursor.getString(cursor.getColumnIndex(Lights.COLUMN_ROOM_NAME));
                boolean status = cursor.getInt(
                        cursor.getColumnIndex(Lights.COLUMN_SET_LIGHT)) == 0 ? false : true;
                res.add(new Lights(id, roomName, status));
            }
        }
        return res;
    }

    @Override
    public void SetRoom(Room room) {
        ContentValues values = new ContentValues();
        values.put(Room.COLUMN_ID, room.GetRoomId());
        values.put(Room.COLUMN_NAME_ROOM, room.GetRoomName());
        values.put(Room.COLUMN_NAME_IMG, room.GetImgName());
        mDB.replace(Room.TABLE_NAME, null, values);
    }

    public List<Room> GetRoomList(){
        List<Room> res = new ArrayList<>();
        String query = "SELECT * FROM " + Room.TABLE_NAME + " ORDER BY " + Room.COLUMN_ID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int idRoom = cursor.getInt(cursor.getColumnIndex(Room.COLUMN_ID));
                String nameRoom = cursor.getString(cursor.getColumnIndex(Room.COLUMN_NAME_ROOM));
                String imgName = cursor.getString(cursor.getColumnIndex(Room.COLUMN_NAME_IMG));
                res.add(new Room(idRoom, nameRoom, imgName));
            }
        }
        return res;
    }

    @Override
    public Room GetRoom(int roomID) {
        String query = "SELECT * FROM " + Room.TABLE_NAME +
                " WHERE " + Room.COLUMN_ID + " = " + roomID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            String nameRoom = cursor.getString(cursor.getColumnIndex(Room.COLUMN_NAME_ROOM));
            String imgName = cursor.getString(cursor.getColumnIndex(Room.COLUMN_NAME_IMG));
            return new Room(roomID, nameRoom, imgName);
        } else {
            Log.e(TAG, "Room record not found for ID: " + roomID);
        }
        return null;
    }

    @Override
    public void SetAppliance(Appliance appl) {
        ContentValues values = new ContentValues();
        values.put(Appliance.COLUMN_ID, appl.GetIdAppliance());
        values.put(Appliance.COLUMN_NAME, appl.GetNameAppliance());
        values.put(Appliance.COLUMN_SET, appl.GetStatus());
        mDB.replace(Appliance.TABLE_NAME, null, values);
    }

    @Override
    public List<Appliance> GetApplianceList() {
        List<Appliance> res = new ArrayList<>();
        String query = "SELECT * FROM " + Appliance.TABLE_NAME + " ORDER BY " + Appliance.COLUMN_ID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int idAppliance = cursor.getInt(cursor.getColumnIndex(Appliance.COLUMN_ID));
                String nameAppliance = cursor.getString(cursor.getColumnIndex(Appliance.COLUMN_NAME));
                boolean status = cursor.getInt(
                        cursor.getColumnIndex(Appliance.COLUMN_SET)) == 0 ? false : true;
                res.add(new Appliance(idAppliance, nameAppliance, status));
            }
        }
        return res;
    }


    public void SetAlerts(Alert alert) {
        ContentValues values = new ContentValues();
        values.put(Alert.COLUMN_TIME, alert.GetTimeAlert().toString());
        values.put(Alert.COLUMN_TYPE, alert.GetTypeAlert());
        values.put(Alert.COLUMN_INDEX, alert.GetIndexAlert());
        mDB.replace(Alert.TABLE_NAME, null, values);
    }

    public List<Alert> GetHealthAlertList() {
        List<Alert> res = new ArrayList<>();
        String query = "SELECT * FROM " + Alert.TABLE_NAME + " WHERE " + Alert.COLUMN_TYPE +
                        " = 'H'" +" ORDER BY " + Alert.COLUMN_ID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String alertType = cursor.getString(cursor.getColumnIndex(Alert.COLUMN_TYPE));
                LocalTime timeAlert = LocalTime.parse(
                        cursor.getString(cursor.getColumnIndex(Alert.COLUMN_TIME)));
                int indexAlert = cursor.getInt(cursor.getColumnIndex(Alert.COLUMN_INDEX));
                res.add(new Alert(timeAlert, alertType, indexAlert));
            }
        }
        return res;
    }

    public List<Alert> GetSecurityAlertList() {
        List<Alert> res = new ArrayList<>();
        String query = "SELECT * FROM " + Alert.TABLE_NAME + " WHERE " + Alert.COLUMN_TYPE +
                        " = 'I'" + " ORDER BY " + Alert.COLUMN_ID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String alertType = cursor.getString(cursor.getColumnIndex(Alert.COLUMN_TYPE));
                LocalTime timeAlert = LocalTime.parse(
                        cursor.getString(cursor.getColumnIndex(Alert.COLUMN_TIME)));
                int indexAlert = cursor.getInt(cursor.getColumnIndex(Alert.COLUMN_INDEX));
                res.add(new Alert(timeAlert, alertType, indexAlert));
            }
        }
        return res;
    }

    @Override
    public void SetEntry(Entry entity) {
        ContentValues values = new ContentValues();
        values.put(Entry.COLUMN_ID, entity.GetDoorId());
        values.put(Entry.COLUMN_NAME, entity.GetDoorName());
        values.put(Entry.COLUMN_SET, entity.GetLocStatus());
        mDB.replace(Entry.TABLE_NAME, null, values);
    }

    @Override
    public List<Entry> GetEntryList() {
        List<Entry> res = new ArrayList<>();
        String query = "SELECT * FROM " + Entry.TABLE_NAME + " ORDER BY " + Entry.COLUMN_ID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int doorId = cursor.getInt(cursor.getColumnIndex(Entry.COLUMN_ID));
                String doorName = cursor.getString(cursor.getColumnIndex(Entry.COLUMN_NAME));
                boolean setLoc = cursor.getInt(
                        cursor.getColumnIndex(Entry.COLUMN_SET)) == 0 ? false : true;
                res.add(new Entry(doorId, doorName, setLoc));
            }
        }
        return res;
    }

    @Override
    public void SetAdmin(Admin admin) {
        ContentValues values = new ContentValues();
        values.put(Admin.COLUMN_ID, admin.GetIdAdmin());
        values.put(Admin.COLUMN_DAY, admin.GetDayAdmin());
        values.put(Admin.COLUMN_TYPE, admin.GetTypeAdmin());
        values.put(Admin.COLUMN_TIME_ON, admin.GetTimeOnAdmin().toString());
        values.put(Admin.COLUMN_TIME_OFF, admin.GetTimeOffAdmin().toString());
        mDB.replace(Admin.TABLE_NAME, null, values);
    }

    @Override
    public Admin GetAdmin(int type, int dayID)
    {
        String query = "SELECT * FROM " + Admin.TABLE_NAME
                + " WHERE " + Admin.COLUMN_TYPE + " = " + type
                + " AND " + Admin.COLUMN_DAY + " = " + dayID;
        Cursor cursor = mDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            int idAdmin = cursor.getInt(cursor.getColumnIndex(Admin.COLUMN_ID));
            LocalTime timeOnAdmin = LocalTime.parse(
                    cursor.getString(cursor.getColumnIndex(Admin.COLUMN_TIME_ON)));
            LocalTime timeOffAdmin = LocalTime.parse(
                    cursor.getString(cursor.getColumnIndex(Admin.COLUMN_TIME_OFF)));
            return new Admin(idAdmin, dayID, type, timeOnAdmin, timeOffAdmin);
        }
        return null;
    }
}
