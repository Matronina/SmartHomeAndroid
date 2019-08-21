package com.example.matronina.myproject.ui.energy;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.example.matronina.myproject.R;
import com.example.matronina.myproject.model.DBHelper;
import com.example.matronina.myproject.model.Temperature;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EnergyFragmentSetTemp extends Fragment {

    private static final String TAG = EnergyFragmentSetTemp.class.getName();

    private int mDayID;
    private Temperature mTemp;
    private DBHelper mDBHelper;

    private Spinner mDayTempSpinner;
    private EditText mDayTimeText;

    private Spinner mNightTempSpinner;
    private EditText mNightTimeText;

    private List<Integer> mTempSpinnerArray;

    public static EnergyFragmentSetTemp newInstance(int dayID) {
        EnergyFragmentSetTemp ins = new EnergyFragmentSetTemp();
        ins.mDayID = dayID;
        return ins;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve values from DB for this day
        mDBHelper = DBHelper.GetInstance(getContext());
        mTemp = mDBHelper.GetTemperature(mDayID);

        mTempSpinnerArray = new ArrayList<>();
        for(int t = 60; t <= 90; ++t) {
            mTempSpinnerArray.add(t);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energy_temp_set, container, false);

        mDayTempSpinner = view.findViewById(R.id.setDayTempSpinner);
        mDayTimeText = view.findViewById(R.id.day_time);
        mNightTempSpinner = view.findViewById(R.id.setNightTempSpinner);
        mNightTimeText = view.findViewById(R.id.night_time);

        if (mTemp == null) {
            Log.e(TAG, "mTemp is null");
            return view;
        }

        SetUpTimePicker(mDayTimeText, true);
        SetUpTimePicker(mNightTimeText, false);

        SetUpTemperatureSpinner(mDayTempSpinner, true);
        SetUpTemperatureSpinner(mNightTempSpinner, false);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void SetUpTimePicker(final EditText editText, final boolean day) {
        editText.setShowSoftInputOnFocus(false);
        final LocalTime time = day ? mTemp.GetDayTime() : mTemp.GetNightTime();
        editText.setText(time.toString());
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    return;
                TimePickerDialog.OnTimeSetListener onTimeSetListener =
                      new TimePickerDialog.OnTimeSetListener() {
                          @Override
                          public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                              LocalTime newTime = LocalTime.of(hourOfDay, minute);
                              if (day) {
                                  mTemp.SetDayTime(newTime);
                              } else {
                                  mTemp.SetNightTime(newTime);
                              }
                              mDBHelper.SetTemperature(mTemp);
                              editText.setText(newTime .toString());
                              //editText.clearFocus();
                          }
                      };

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                      onTimeSetListener, time.getHour(), time.getMinute(), false);
                timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        //editText.clearFocus();
                    }
                });
                timePickerDialog.show();
            }
        });
    }

    private void SetUpTemperatureSpinner(final Spinner spinner, final boolean day) {
        spinner.setAdapter(new ArrayAdapter<>(
                getActivity(),android.R.layout.simple_spinner_dropdown_item, mTempSpinnerArray));

        int pos = mTempSpinnerArray.indexOf(day ? mTemp.GetDayTemp() : mTemp.GetNightTemp());
        spinner.setSelection(pos);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int newTemp = mTempSpinnerArray.get(position);
                if (day) {
                    mTemp.SetDayTemp(newTemp);
                } else {
                    mTemp.SetNightTemp(newTemp);
                }
                mDBHelper.SetTemperature(mTemp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

