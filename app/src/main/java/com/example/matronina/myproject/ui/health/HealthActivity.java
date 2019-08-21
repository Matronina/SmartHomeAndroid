package com.example.matronina.myproject.ui.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.matronina.myproject.ui.Utils;
import com.example.matronina.myproject.R;


public class HealthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.healthFrameContainer, new HealthFragmentMenu()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return Utils.OnMainMenuOptionSelected(this, item);
    }
}