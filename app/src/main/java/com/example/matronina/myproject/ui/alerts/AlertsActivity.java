package com.example.matronina.myproject.ui.alerts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.matronina.myproject.ui.Utils;
import com.example.matronina.myproject.R;
import com.example.matronina.myproject.model.Alert;
import com.example.matronina.myproject.model.AlertsHelper;
import com.example.matronina.myproject.model.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class AlertsActivity extends AppCompatActivity {

    private List<Alert> mAlertList;
    private ListView mAlertsView;
    private TextView mNoAlertsLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        mAlertsView = findViewById(R.id.newAlertsListView);
        mNoAlertsLabel = findViewById(R.id.noNewAlertsLabel);

        mAlertList = AlertsHelper.GenerateRandomAlerts();

        DBHelper dbHelper = DBHelper.GetInstance(getApplicationContext());
        for (Alert alert : mAlertList) {
            dbHelper.SetAlerts(alert);
        }

        if (mAlertList.isEmpty()) {
            mNoAlertsLabel.setVisibility(View.VISIBLE);
        } else {
            final List<String> alertTextList = new ArrayList<>();
            for(Alert alert : mAlertList) {
                String alertText =  " • " +
                        AlertsHelper.GetAlertText(alert.GetTypeAlert(), alert.GetIndexAlert())
                        + " [" + alert.GetTimeAlert().toString() + "]";
                alertTextList.add(alertText);
            }

            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                    (this, android.R.layout.simple_list_item_1, alertTextList);
            mAlertsView.setAdapter(arrayAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return Utils.OnMainMenuOptionSelected(this, item);
    }
}
