package com.example.matronina.myproject.ui.protection;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import com.example.matronina.myproject.R;
import com.example.matronina.myproject.model.DBHelper;
import com.example.matronina.myproject.model.Room;

public class ProtectionFragmentRoomView extends Fragment {
    private static final String TAG = ProtectionFragmentRoomView.class.getName();

    private TextView mRoomNameLabel;
    private ImageView mImageView;

    private DBHelper mDBHelper;
    private Room mRoom;
    private int mRoomID;
    private int mDrawableResourseID;

    public static ProtectionFragmentRoomView newInstance(int roomID) {
        ProtectionFragmentRoomView ins = new ProtectionFragmentRoomView();
        ins.mRoomID = roomID;
        switch(roomID) {
            case Room.KITCHEN_ID:
                ins.mDrawableResourseID = R.drawable.kitchen;
                break;
            case Room.BATHROOM_ID:
                ins.mDrawableResourseID = R.drawable.bathroom;
                break;
            case Room.BEDROOM_ID:
                ins.mDrawableResourseID = R.drawable.bedroom;
                break;
            case Room.LIVING_ROOM_ID:
                ins.mDrawableResourseID = R.drawable.living_room;
                break;
            case Room.DINING_ROOM_ID:
                ins.mDrawableResourseID = R.drawable.dining_room;
                break;
            default:
                Log.e(TAG, "Unexpected room ID: " + roomID);
        }
        return ins;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDBHelper = DBHelper.GetInstance(getContext());
        mRoom = mDBHelper.GetRoom(mRoomID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_protection_room_view, container, false);

        mRoomNameLabel = view.findViewById(R.id.roomNameLabel);
        mRoomNameLabel.setText(mRoom.GetRoomName());

        mImageView = view.findViewById(R.id.roomImageView);
        Resources res = getResources();
        Drawable drawable = ResourcesCompat.getDrawable(res, mDrawableResourseID, null);
        mImageView.setImageDrawable(drawable);

        return view;
    }
}