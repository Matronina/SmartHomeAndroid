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
import com.example.matronina.myproject.model.DBHelper;
import com.example.matronina.myproject.model.Lights;

import java.util.List;

public class EnergyFragmentSetLights extends Fragment {
    private static final String TAG = EnergyFragmentSetLights.class.getName();

    DBHelper mDBHelper;
    List<Lights> mLightsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDBHelper = DBHelper.GetInstance(getContext());
        mLightsList = mDBHelper.GetLightsList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energy_set_lights, container, false);

        for (final Lights lights : mLightsList) {
            final Switch sw = (Switch)inflater.inflate(R.layout.switch_item, container, false);
            sw.setText(lights.GetRoomName());
            sw.setChecked(lights.GetStatus());
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    lights.SetStatus(isChecked);
                    mDBHelper.SetLights(lights);
                }
            });
            LinearLayout layout = view.findViewById(R.id.setLightsLayout);
            layout.addView(sw);
        }

        return view;
    }
}
