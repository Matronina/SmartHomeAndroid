package com.example.matronina.myproject.ui.energy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.matronina.myproject.R;

import static com.example.matronina.myproject.ui.Utils.PerformFragmentTransaction;

public class EnergyFragmentTempSelectDay extends Fragment implements View.OnClickListener {

    private static final String TAG = EnergyFragmentTempSelectDay.class.getName();

    Button mSundayButton;
    Button mMondayButton;
    Button mTuesdayButton;
    Button mWednesdayButton;
    Button mThursdayButton;
    Button mFridayButton;
    Button mSaturdayButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energy_temp_day, container, false);

        // Set days buttons
        mSundayButton = view.findViewById(R.id.sundayButton);
        mSundayButton.setOnClickListener(this);

        mMondayButton = view.findViewById(R.id.mondayButton);
        mMondayButton.setOnClickListener(this);

        mTuesdayButton = view.findViewById(R.id.tuesdayButton);
        mTuesdayButton.setOnClickListener(this);

        mWednesdayButton = view.findViewById(R.id.wednesdayButton);
        mWednesdayButton.setOnClickListener(this);

        mThursdayButton = view.findViewById(R.id.thursdayButton);
        mThursdayButton.setOnClickListener(this);

        mFridayButton = view.findViewById(R.id.fridayButton);
        mFridayButton.setOnClickListener(this);

        mSaturdayButton = view.findViewById(R.id.saturdayButton);
        mSaturdayButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Integer dayID;
        switch (v.getId()) {
            case R.id.sundayButton:
                dayID = 1;
                break;
            case R.id.mondayButton:
                dayID = 2;
                break;
            case R.id.tuesdayButton:
                dayID = 3;
                break;
            case R.id.wednesdayButton:
                dayID = 4;
                break;
            case R.id.thursdayButton:
                dayID = 5;
                break;
            case R.id.fridayButton:
                dayID = 6;
                break;
            case R.id.saturdayButton:
                dayID = 7;
                break;
            default:
                Log.e(TAG, "Unexpected button ID: " + v.getId());
                return;
        }
        PerformFragmentTransaction(getFragmentManager(), R.id.energyFrameContainer,
                EnergyFragmentSetTemp.newInstance(dayID));
    }
}
