package com.example.matronina.myproject.ui.protection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.matronina.myproject.R;
import static com.example.matronina.myproject.ui.Utils.*;

public class ProtectionFragmentMenu extends Fragment implements View.OnClickListener {
    private static final String TAG = ProtectionFragmentMenu.class.getName();
    private Button mViewRoomsButton;
    private Button mProtectionAlertHistoryButton;
    private Button mEntryAccessButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_protection_menu, container, false);
        mViewRoomsButton = view.findViewById(R.id.viewRoomsButton);
        mProtectionAlertHistoryButton = view.findViewById(R.id.protectionAlertHistoryButton);
        mEntryAccessButton = view.findViewById(R.id.entryAccessButton);
        mViewRoomsButton.setOnClickListener(this);
        mProtectionAlertHistoryButton.setOnClickListener(this);
        mEntryAccessButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.viewRoomsButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.protectionFrameContainer,
                        new ProtectionFragmentSelectRoom());
                break;
            case R.id.protectionAlertHistoryButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.protectionFrameContainer,
                        new ProtectionFragmentAlertHistory());
                break;
            case R.id.entryAccessButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.protectionFrameContainer,
                        new ProtectionFragmentSetLocks());
                break;
            default:
                Log.e(TAG, "Unexpected button ID: " + v.getId());
        }
    }
}
