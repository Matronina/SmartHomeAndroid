package com.example.matronina.myproject.model;

public class Appliance {
    public static final String TABLE_NAME = "Appliance";
    public static final String COLUMN_ID = "id_appl";
    public static final String COLUMN_NAME = "name_appl";
    public static final String COLUMN_SET = "set_on_off_appl";

    final private int idAppliance;
    final private String nameAppliance;
    private boolean status;

    public Appliance(int idAppliance, String nameAppliance, boolean status) {
        this.idAppliance = idAppliance;
        this.nameAppliance = nameAppliance;
        this.status = status;
    }

    public String GetNameAppliance() { return nameAppliance; }
    public int GetIdAppliance() { return idAppliance; }
    public boolean GetStatus() { return status; }
    public void SetStatus(boolean val) { status = val; }
}
