package com.example.matronina.myproject.model;

import android.util.Log;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public final class AlertsHelper {

    public static final String KNOWN_HEALTH_ALERTS[] = {
            "health alert 1",
            "health alert 2",
            "health alert 3",
            "health alert 4",
            "health alert 5",
            "health alert 6"
    };

    public static final String KNOWN_SECURITY_ALERTS[] = {
            "security alert 1",
            "security alert 2",
            "security alert 3",
            "security alert 4",
            "security alert 5",
            "security alert 6"
    };

    private static final int MAX_INITIAL_ALERT_NUMBER = 5;

    private static final String LOG_TAG = AlertsHelper.class.getName();

    public static List<Alert> GenerateRandomAlerts()
    {
        List<Alert> res = new ArrayList<>();

        Random rand = new Random();
        int alertsNumber = rand.nextInt(MAX_INITIAL_ALERT_NUMBER);
        while(alertsNumber >= 0) {
            --alertsNumber;

            int index;
            String type;
            boolean healthAlert = rand.nextBoolean();
            if (healthAlert) {
                index = rand.nextInt(KNOWN_HEALTH_ALERTS.length);
                type = Alert.ALERT_TYPE_HEALTH;
            } else { // Security alert
                index = rand.nextInt(KNOWN_SECURITY_ALERTS.length);
                type = Alert.ALERT_TYPE_SECURITY;
            }
            int hour = rand.nextInt(24);
            int minute = rand.nextInt(60);
            LocalTime time = LocalTime.of(hour, minute);

            Alert alert = new Alert(time, type, index);
            res.add(alert);
        }

        // Sort alerts by time
        class SortByTime implements Comparator<Alert>
        {
            public int compare(Alert a, Alert b)
            {
                return a.GetTimeAlert().compareTo(b.GetTimeAlert());
            }
        }
        Collections.sort(res, new SortByTime());

        return res;
    }

    public static String GetAlertText(String type, int index) {
        if (Alert.ALERT_TYPE_HEALTH.equals(type)) {
            if (index >= 0 && index < KNOWN_HEALTH_ALERTS.length) {
                return KNOWN_HEALTH_ALERTS[index];
            } else {
                Log.e(LOG_TAG, "index is out of bounds: " + index);
            }
        } else if (Alert.ALERT_TYPE_SECURITY.equals(type)) {
            if (index >= 0 && index < KNOWN_SECURITY_ALERTS.length) {
                return KNOWN_SECURITY_ALERTS[index];
            } else {
                Log.e(LOG_TAG, "index is out of bounds: " + index);
            }
        } else {
            Log.e(LOG_TAG, "Unknown alert type: " + type);
        }
        return "";
    }
}
