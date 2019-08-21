package com.example.matronina.myproject.ui.energy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.matronina.myproject.R;
import com.example.matronina.myproject.model.Appliance;
import com.example.matronina.myproject.model.DBHelper;

import java.util.List;

public class EnergyFragmentSetAppliance extends Fragment {

    private static final String TAG = EnergyFragmentSetAppliance.class.getName();

    DBHelper mDBHelper;
    List<Appliance> mApplianceList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDBHelper = DBHelper.GetInstance(getContext());
        mApplianceList = mDBHelper.GetApplianceList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energy_set_appl, container, false);

        for (final Appliance appl : mApplianceList) {
            final Switch sw = (Switch)inflater.inflate(R.layout.switch_item, container, false);
            sw.setText(appl.GetNameAppliance());
            sw.setChecked(appl.GetStatus());
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    appl.SetStatus(isChecked);
                    mDBHelper.SetAppliance(appl);
                }
            });
            LinearLayout layout = view.findViewById(R.id.setAppliancesLayout);
            layout.addView(sw);
        }

        return view;
    }
}
