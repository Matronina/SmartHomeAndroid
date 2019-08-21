package com.example.matronina.myproject.ui.protection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.matronina.myproject.R;
import com.example.matronina.myproject.model.Room;

import static com.example.matronina.myproject.ui.Utils.*;


public class ProtectionFragmentSelectRoom extends Fragment implements View.OnClickListener {
    private static final String TAG = ProtectionFragmentSelectRoom.class.getName();

    Button vKitchenButton;
    Button vBedroomButton;
    Button vBathroomButton;
    Button vLivingRoomButton;
    Button vDiningRoomButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_protection_select_room, container, false);

        vKitchenButton = view.findViewById(R.id.viewKitchenButton);
        vKitchenButton.setOnClickListener(this);

        vBedroomButton = view.findViewById(R.id.viewBedroomButton);
        vBedroomButton.setOnClickListener(this);

        vBathroomButton = view.findViewById(R.id.viewBathroomButton);
        vBathroomButton.setOnClickListener(this);

        vLivingRoomButton = view.findViewById(R.id.viewLivingRoomButton);
        vLivingRoomButton.setOnClickListener(this);

        vDiningRoomButton = view.findViewById(R.id.viewDiningRoomButton);
        vDiningRoomButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.viewKitchenButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.protectionFrameContainer,
                        ProtectionFragmentRoomView.newInstance(Room.KITCHEN_ID));
                break;
            case R.id.viewBedroomButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.protectionFrameContainer,
                        ProtectionFragmentRoomView.newInstance(Room.BEDROOM_ID));
                break;
            case R.id.viewBathroomButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.protectionFrameContainer,
                        ProtectionFragmentRoomView.newInstance(Room.BATHROOM_ID));
                break;
            case R.id.viewLivingRoomButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.protectionFrameContainer,
                        ProtectionFragmentRoomView.newInstance(Room.LIVING_ROOM_ID));
                break;
            case R.id.viewDiningRoomButton:
                PerformFragmentTransaction(getFragmentManager(), R.id.protectionFrameContainer,
                        ProtectionFragmentRoomView.newInstance(Room.DINING_ROOM_ID));
                break;
            default:
                Log.e(TAG, "Unexpected button ID: " + v.getId());
        }
    }
}
