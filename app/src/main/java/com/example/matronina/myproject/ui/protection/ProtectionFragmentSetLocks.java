package com.example.matronina.myproject.ui.protection;

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
import com.example.matronina.myproject.model.Entry;

import java.util.List;


public class ProtectionFragmentSetLocks extends Fragment {
    private static final String TAG = ProtectionFragmentSetLocks.class.getName();

    private DBHelper mDBHelper;
    private List<Entry> mEntryList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDBHelper = DBHelper.GetInstance(getContext());
        mEntryList = mDBHelper.GetEntryList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_protection_set_locks, container, false);

        for (final Entry entry: mEntryList) {
            final Switch sw = (Switch)inflater.inflate(R.layout.switch_item, container, false);
            sw.setText(entry.GetDoorName());
            sw.setChecked(entry.GetLocStatus());
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    entry.SetLocStatus(isChecked);
                    mDBHelper.SetEntry(entry);
                }
            });
            LinearLayout layout = view.findViewById(R.id.setEntryLocksLayout);
            layout.addView(sw);
        }

        return view;
    }
}