package com.example.matronina.myproject.ui.health;

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


public class HealthAlertHistoryFragment extends Fragment {
    private static final String TAG = HealthAlertHistoryFragment.class.getName();

    private List<Alert> mAlertsList;
    private ListView mAlertsView;
    private TextView mNoAlertsLabel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health_alert_history, container, false);

        mAlertsView = view.findViewById(R.id.healthAlertsListView);
        mNoAlertsLabel = view.findViewById(R.id.healthNoAlertsLabel);

        DBHelper dbHelper = DBHelper.GetInstance(getContext());
        mAlertsList = dbHelper.GetHealthAlertList();
        Collections.reverse(mAlertsList); // reverse the list, so most recent alerts will be on top

        if (mAlertsList.isEmpty()) {
            mNoAlertsLabel.setVisibility(View.VISIBLE);
        } else {
            final List<String> alertTextList = new ArrayList<>();
            for(Alert alert : mAlertsList) {
                String alertText =  " • " +
                        AlertsHelper.GetAlertText(alert.GetTypeAlert(), alert.GetIndexAlert())
                        + " [" + alert.GetTimeAlert().toString() + "]";
                alertTextList.add(alertText);
            }
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                    (getContext(), android.R.layout.simple_list_item_1, alertTextList);
            mAlertsView.setAdapter(arrayAdapter);
        }
        return view;
    }
}
