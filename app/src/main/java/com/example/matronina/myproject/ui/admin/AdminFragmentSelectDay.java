package com.example.matronina.myproject.ui.admin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.matronina.myproject.R;

import static com.example.matronina.myproject.ui.Utils.PerformFragmentTransaction;


public class AdminFragmentSelectDay extends Fragment implements View.OnClickListener {

    private static final String TAG = AdminFragmentSelectDay.class.getName();

    Button mSundayButtonEnergy;
    Button mMondayButtonEnergy;
    Button mTuesdayButtonEnergy;
    Button mWednesdayButtonEnergy;
    Button mThursdayButtonEnergy;
    Button mFridayButtonEnergy;
    Button mSaturdayButtonEnergy;

    private int mAdminType;

    public static AdminFragmentSelectDay newInstance(int type) {
        AdminFragmentSelectDay ins = new AdminFragmentSelectDay();
        ins.mAdminType = type;
        return ins;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_select_day, container, false);
        // Set days buttons
        mSundayButtonEnergy = view.findViewById(R.id.sundayAdminButton);
        mSundayButtonEnergy.setOnClickListener(this);

        mMondayButtonEnergy = view.findViewById(R.id.mondayAdminButton);
        mMondayButtonEnergy.setOnClickListener(this);

        mTuesdayButtonEnergy = view.findViewById(R.id.tuesdayAdminButton);
        mTuesdayButtonEnergy.setOnClickListener(this);

        mWednesdayButtonEnergy = view.findViewById(R.id.wednesdayAdminButton);
        mWednesdayButtonEnergy.setOnClickListener(this);

        mThursdayButtonEnergy = view.findViewById(R.id.thursdayAdminButton);
        mThursdayButtonEnergy.setOnClickListener(this);

        mFridayButtonEnergy = view.findViewById(R.id.fridayAdminButton);
        mFridayButtonEnergy.setOnClickListener(this);

        mSaturdayButtonEnergy = view.findViewById(R.id.saturdayAdminButton);
        mSaturdayButtonEnergy.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Integer dayID;
        switch (v.getId()) {
            case R.id.sundayAdminButton:
                dayID = 1;
                break;
            case R.id.mondayAdminButton:
                dayID = 2;
                break;
            case R.id.tuesdayAdminButton:
                dayID = 3;
                break;
            case R.id.wednesdayAdminButton:
                dayID = 4;
                break;
            case R.id.thursdayAdminButton:
                dayID = 5;
                break;
            case R.id.fridayAdminButton:
                dayID = 6;
                break;
            case R.id.saturdayAdminButton:
                dayID = 7;
                break;
            default:
                Log.e(TAG, "Unexpected button ID: " + v.getId());
                return;
        }
        PerformFragmentTransaction(getFragmentManager(), R.id.adminFrameContainer,
                AdminFragmentSetArmTime.newInstance(mAdminType, dayID));
    }
}

