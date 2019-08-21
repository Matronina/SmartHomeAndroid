package com.example.matronina.myproject.model;

import java.time.LocalTime;

public final class Temperature {
    public static final String TABLE_NAME = "Temp";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "day_of_week";
    public static final String COLUMN_DAY_TIME = "day_time";
    public static final String COLUMN_DAY_TEMP = "day_temp";
    public static final String COLUMN_NIGHT_TIME = "night_time";
    public static final String COLUMN_NIGHT_TEMP = "night_temp";

    private final int dayID;
    private final String name;
    private LocalTime dayTime;
    private int dayTemp;
    private LocalTime nightTime;
    private int nightTemp;

    public Temperature(int dayID, String name, LocalTime dayTime,
                       int dayTemp, LocalTime nightTime, int nightTemp)
    {
        this.dayID = dayID;
        this.name = name;
        this.dayTime = dayTime;
        this.dayTemp = dayTemp;
        this.nightTime = nightTime;
        this.nightTemp = nightTemp;
    }

    public int GetDayID() { return dayID; }
    public String GetName() { return name; }
    public LocalTime GetDayTime() { return dayTime; }
    public void SetDayTime(LocalTime time) { dayTime = time; }
    public int GetDayTemp() { return dayTemp; }
    public void SetDayTemp(int temp) { dayTemp = temp; }
    public LocalTime GetNightTime() { return nightTime; }
    public void SetNightTime(LocalTime time) { nightTime = time; }
    public int GetNightTemp() { return nightTemp; }
    public void SetNightTemp(int temp) { nightTemp = temp; }
}
