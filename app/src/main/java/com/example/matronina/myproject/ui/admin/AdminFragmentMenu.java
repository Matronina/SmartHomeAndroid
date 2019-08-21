package com.example.matronina.myproject.ui.admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.matronina.myproject.R;
import com.example.matronina.myproject.model.Admin;

import static com.example.matronina.myproject.ui.Utils.*;


public class AdminFragmentMenu extends Fragment implements OnClickListener{
    private static final String TAG = AdminFragmentMenu.class.getName();
    private Button mHealthAccessButton;
    private Button mEnergyAccessButton;
    private Button mProtectionAccessButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_menu, container, false);
        mHealthAccessButton = view.findViewById(R.id.healthAccessButton);
        mEnergyAccessButton = view.findViewById(R.id.energyAccessButton);
        mProtectionAccessButton = view.findViewById(R.id.protectionAccessButton);
        mHealthAccessButton.setOnClickListener(this);
        mEnergyAccessButton.setOnClickListener(this);
        mProtectionAccessButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.healthAccessButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.adminFrameContainer,
                        AdminFragmentSelectDay.newInstance(Admin.ADMIN_TYPE_HEALTH));
                break;
            case R.id.energyAccessButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.adminFrameContainer,
                        AdminFragmentSelectDay.newInstance(Admin.ADMIN_TYPE_ENERGY));
                break;
            case R.id.protectionAccessButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.adminFrameContainer,
                        AdminFragmentSelectDay.newInstance(Admin.ADMIN_TYPE_PROTECTION));
                break;
            default:
                Log.e(TAG, "Unexpected button ID: " + v.getId());
        }
    }

}
