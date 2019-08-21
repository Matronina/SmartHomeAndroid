package com.example.matronina.myproject.ui.protection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.matronina.myproject.ui.Utils;
import com.example.matronina.myproject.R;


public class ProtectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.protectionFrameContainer, new ProtectionFragmentMenu()).commit();
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
