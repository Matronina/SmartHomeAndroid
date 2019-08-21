package com.example.matronina.myproject.ui.health;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.matronina.myproject.R;
import static com.example.matronina.myproject.ui.Utils.*;

public class HealthFragmentMenu extends Fragment implements View.OnClickListener{
    private static final String TAG = HealthFragmentMenu.class.getName();
    private Button mHealthAlertButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health_menu, container, false);
        mHealthAlertButton = view.findViewById(R.id.healthAlertButton);
        mHealthAlertButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.healthAlertButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.healthFrameContainer,
                        new HealthAlertHistoryFragment());
                break;

            default:
                Log.e(TAG, "Unexpected button ID: " + v.getId());
        }
    }
}
