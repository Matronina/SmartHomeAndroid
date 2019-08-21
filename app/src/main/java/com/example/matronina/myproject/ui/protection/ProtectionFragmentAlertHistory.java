package com.example.matronina.myproject.ui.protection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.matronina.myproject.R;
import com.example.matronina.myproject.model.Alert;
import com.example.matronina.myproject.model.AlertsHelper;
import com.example.matronina.myproject.model.DBHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProtectionFragmentAlertHistory extends Fragment {
    private static final String TAG = ProtectionFragmentAlertHistory.class.getName();

    private List<Alert> mAlertsListProtect;
    private ListView mAlertsViewProtect;
    private TextView mNoAlertsLabelProtect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_protection_alert_history, container, false);

        mAlertsViewProtect = view.findViewById(R.id.protectionAlertsListView);
        mNoAlertsLabelProtect = view.findViewById(R.id.protectionNoAlertsLabel);

        DBHelper dbHelper = DBHelper.GetInstance(getContext());
        mAlertsListProtect = dbHelper.GetSecurityAlertList();
        Collections.reverse(mAlertsListProtect); // reverse the list, so most recent alerts will be on top

        if (mAlertsListProtect.isEmpty()) {
            mNoAlertsLabelProtect.setVisibility(View.VISIBLE);
        } else {
            final List<String> alertTextList = new ArrayList<>();
            for(Alert alert : mAlertsListProtect) {
                String alertText =  " • " +
                        AlertsHelper.GetAlertText(alert.GetTypeAlert(), alert.GetIndexAlert())
                        + " [" + alert.GetTimeAlert().toString() + "]";
                alertTextList.add(alertText);
            }
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                    (getContext(), android.R.layout.simple_list_item_1, alertTextList);
            mAlertsViewProtect.setAdapter(arrayAdapter);
        }
        return view;
    }
}