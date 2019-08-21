package com.example.matronina.myproject.ui.admin;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.matronina.myproject.R;
import com.example.matronina.myproject.model.Admin;
import com.example.matronina.myproject.model.DBHelper;
import com.example.matronina.myproject.ui.Utils;

import java.time.LocalTime;


public class AdminFragmentSetArmTime extends Fragment {

    private static final String TAG = AdminFragmentSetArmTime.class.getName();

    private TextView mTypeDayLabel;

    private EditText mSetArmOnTime;
    private EditText mSetArmOffTime;

    private int mAdminType;
    private int mDayID;

    private DBHelper mDBHelper;
    private Admin mAdmin;

    public AdminFragmentSetArmTime() {
    }

    public static AdminFragmentSetArmTime newInstance(int type, int dayID) {
        AdminFragmentSetArmTime ins = new AdminFragmentSetArmTime();
        ins.mAdminType = type;
        ins.mDayID = dayID;
        return ins;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDBHelper = DBHelper.GetInstance(getContext());
        mAdmin = mDBHelper.GetAdmin(mAdminType, mDayID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_set_arm_time, container, false);

        mTypeDayLabel = view.findViewById(R.id.setArmTimeTypeDayLabel);
        String labelText = "";
        switch(mAdminType) {
            case Admin.ADMIN_TYPE_HEALTH:
                labelText += "Health";
                break;
            case Admin.ADMIN_TYPE_ENERGY:
                labelText += "Energy";
                break;
            case Admin.ADMIN_TYPE_PROTECTION:
                labelText += "Protection";
                break;
            default:
                Log.w(TAG, "Unexpected admin type: " + mAdminType);
        }
        labelText += " – " + Utils.GetDayNameByID(mDayID);
        mTypeDayLabel.setText(labelText);

        mSetArmOnTime = view.findViewById(R.id.arm_on_time);
        SetUpTimePicker(mSetArmOnTime, true);

        mSetArmOffTime = view.findViewById(R.id.arm_off_time);
        SetUpTimePicker(mSetArmOffTime, false);

        return view;
    }

    private void SetUpTimePicker(final EditText editText, final boolean armOn) {
        editText.setShowSoftInputOnFocus(false);
        if (mAdmin == null) {
            Log.e(TAG, "mAdmin is null. Type: " + mAdminType + " dayID: " + mDayID);
            return;
        }
        LocalTime time = armOn ? mAdmin.GetTimeOnAdmin() : mAdmin.GetTimeOffAdmin();
        editText.setText(time.toString());
        final int currentHour = time.getHour();
        final int currentMinute = time.getMinute();
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
                                if (armOn) {
                                    mAdmin.SetTimeOnAdmin(newTime);
                                } else {
                                    mAdmin.SetTimeOffAdmin(newTime);
                                }
                                mDBHelper.SetAdmin(mAdmin);
                                editText.setText(newTime.toString());
                                //editText.clearFocus();
                            }
                        };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        onTimeSetListener, currentHour, currentMinute, false);
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
}