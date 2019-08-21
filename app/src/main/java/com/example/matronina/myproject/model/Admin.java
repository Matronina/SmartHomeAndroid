package com.example.matronina.myproject.model;

import java.time.LocalTime;

public class Admin {
    public static final String TABLE_NAME = "Admin";
    public static final String COLUMN_ID = "id_admin";
    public static final String COLUMN_DAY = "day_admin";
    public static final String COLUMN_TYPE = "type_admin";
    public static final String COLUMN_TIME_ON = "time_on_admin";
    public static final String COLUMN_TIME_OFF = "time_off_admin";

    public static final int ADMIN_TYPE_HEALTH = 1;
    public static final int ADMIN_TYPE_PROTECTION = 2;
    public static final int ADMIN_TYPE_ENERGY = 3;

    private final int idAdmin;
    private final int dayAdmin;
    private final int typeAdmin;
    private LocalTime timeOnAdmin;
    private LocalTime timeOffAdmin;

    public Admin(int idAdmin, int dayAdmin, int typeAdmin, LocalTime timeOnAdmin, LocalTime timeOffAdmin) {
        this.idAdmin = idAdmin;
        this.dayAdmin = dayAdmin;
        this.typeAdmin = typeAdmin;
        this.timeOnAdmin = timeOnAdmin;
        this.timeOffAdmin = timeOffAdmin;
    }

    public int GetIdAdmin() { return idAdmin; }
    public int GetDayAdmin() { return dayAdmin; }
    public int GetTypeAdmin() { return typeAdmin; }
    public LocalTime GetTimeOnAdmin() { return timeOnAdmin; }
    public void SetTimeOnAdmin(LocalTime time) { timeOnAdmin = time; }
    public LocalTime GetTimeOffAdmin() { return timeOffAdmin; }
    public void SetTimeOffAdmin(LocalTime time) { timeOffAdmin = time; }
}
