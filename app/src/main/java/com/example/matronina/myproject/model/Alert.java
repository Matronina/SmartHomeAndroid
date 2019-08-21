package com.example.matronina.myproject.model;

import java.time.LocalTime;

public final class Alert {
    public static final String TABLE_NAME = "Alert";
    public static final String COLUMN_ID = "id_alert";
    public static final String COLUMN_TIME = "time_alert";
    public static final String COLUMN_TYPE = "type_alert";
    public static final String COLUMN_INDEX = "index_alert";

    public static String ALERT_TYPE_HEALTH = "H";
    public static String ALERT_TYPE_SECURITY = "I";

    private final LocalTime timeAlert;
    private final String typeAlert;
    private final int indexAlert;

    public Alert(LocalTime timeAlert, String typeAlert, int indexAlert)
    {
        this.timeAlert = timeAlert;
        this.typeAlert = typeAlert;
        this.indexAlert = indexAlert;
    }

    public LocalTime GetTimeAlert() { return timeAlert; }
    public String GetTypeAlert() { return typeAlert; }
    public int GetIndexAlert() { return indexAlert; }
}
