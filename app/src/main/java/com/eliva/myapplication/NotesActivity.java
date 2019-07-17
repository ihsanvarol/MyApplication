package com.eliva.myapplication;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class NotesActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_notes);
                    changeFragment(1);
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_reminders);
                    changeFragment(2);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_passes);
                    changeFragment(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //mTextMessage = findViewById(R.id.message);
        //
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //changeFragment(1);
    }

    public void changeFragment(int fid)
    {
       Fragment fragment;
       FragmentManager fm = getSupportFragmentManager();
       FragmentTransaction ft = fm.beginTransaction();
       switch (fid)
       {
           case 1:
               fragment = new NotesFragment();
               fm = getSupportFragmentManager();
               ft = fm.beginTransaction();
               ft.replace(R.id.pass_fragment, fragment);
               ft.commit();
           case 2:
               fragment = new ReminderFragment();
               fm = getSupportFragmentManager();
               ft = fm.beginTransaction();
               ft.replace(R.id.pass_fragment, fragment);
               ft.commit();
           case 3:
               fragment = new PassFragment();
               fm = getSupportFragmentManager();
               ft = fm.beginTransaction();
               ft.replace(R.id.pass_fragment, fragment);
               ft.commit();
       }

    }



}
