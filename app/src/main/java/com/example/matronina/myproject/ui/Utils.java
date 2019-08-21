package com.example.matronina.myproject.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;

import com.example.matronina.myproject.R;
import com.example.matronina.myproject.ui.admin.AdminActivity;
import com.example.matronina.myproject.ui.energy.EnergyActivity;
import com.example.matronina.myproject.ui.health.HealthActivity;
import com.example.matronina.myproject.ui.protection.ProtectionActivity;

public final class Utils {
    private static final String TAG = Utils.class.getName();

    public static void PerformFragmentTransaction(FragmentManager manager,
                                                  int resourceId, Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(resourceId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static boolean OnMainMenuOptionSelected(Activity activity, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_health:
                if (false == activity instanceof HealthActivity)
                    activity.startActivity(new Intent(activity.getApplicationContext(), HealthActivity.class));
                break;
            case R.id.menu_security:
                if (false == activity instanceof ProtectionActivity)
                    activity.startActivity(new Intent(activity.getApplicationContext(), ProtectionActivity.class));
                break;
            case R.id.menu_energy:
                if (false == activity instanceof EnergyActivity)
                    activity.startActivity(new Intent(activity.getApplicationContext(), EnergyActivity.class));
                break;
            case R.id.menu_admin:
                if (false == activity instanceof AdminActivity)
                    activity.startActivity(new Intent(activity.getApplicationContext(), AdminActivity.class));
                break;
            default:
                Log.d("MENU", "Unknown menu item id: " + item.getItemId());
        }
        return true;
    }

    public static String GetDayNameByID(int dayID) {
        switch (dayID) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                Log.e(TAG, "Unexpected day ID: " + dayID);
        }
        return "";
    }
}
