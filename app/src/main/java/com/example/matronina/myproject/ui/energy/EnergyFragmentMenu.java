package com.example.matronina.myproject.ui.energy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.matronina.myproject.R;

import static com.example.matronina.myproject.ui.Utils.*;

public class EnergyFragmentMenu extends Fragment implements View.OnClickListener {

    private static final String TAG = EnergyFragmentMenu.class.getName();
    private Button mTemperatureButton;
    private Button mLightsButton;
    private Button mAppliancesButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energy_menu, container, false);
        mTemperatureButton = view.findViewById(R.id.setTempButton);
        mLightsButton = view.findViewById(R.id.setlightsButton);
        mAppliancesButton = view.findViewById(R.id.setappliancesButton);
        mTemperatureButton.setOnClickListener(this);
        mLightsButton.setOnClickListener(this);
        mAppliancesButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setTempButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.energyFrameContainer,
                        new EnergyFragmentTempSelectDay());
                break;
            case R.id.setlightsButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.energyFrameContainer,
                        new EnergyFragmentSetLights());
                break;
            case R.id.setappliancesButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.energyFrameContainer,
                        new EnergyFragmentSetAppliance());
                break;
            default:
                Log.e(TAG, "Unexpected button ID: " + v.getId());
        }
    }
}
