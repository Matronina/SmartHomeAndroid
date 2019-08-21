package com.example.matronina.myproject.model;
import java.util.List;

public interface IDBHelper {
    void SetTemperature(Temperature temp);
    Temperature GetTemperature(int id);

    void SetLights(Lights lights);
    List<Lights> GetLightsList();

    void SetAppliance(Appliance appl);
    List<Appliance> GetApplianceList();

    void SetRoom(Room room);
    Room GetRoom(int id);
    List<Room> GetRoomList();

    void SetAlerts(Alert alert);
    List<Alert> GetHealthAlertList();
    List<Alert> GetSecurityAlertList();

    void SetEntry(Entry entity);
    List<Entry> GetEntryList();

    void SetAdmin(Admin admin);
    Admin GetAdmin(int type, int day);
}
