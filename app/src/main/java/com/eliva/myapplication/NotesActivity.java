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

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.navigation_notes:
                    selectedFragment = new NotesFragment();
                    break;
                case R.id.navigation_reminder:
                    selectedFragment = new ReminderFragment();
                    break;
                case R.id.navigation_pass:
                    selectedFragment = new PassFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        BottomNavigationView navView = findViewById(R.id.nav_view_notes);
        //mTextMessage = findViewById(R.id.message);
        //
        navView.setOnNavigationItemSelectedListener(navListener);
        navView.setSelectedItemId(R.id.navigation_notes);
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
               ft.replace(R.id.fragment_container, fragment);
               ft.commit();
           case 2:
               fragment = new ReminderFragment();
               fm = getSupportFragmentManager();
               ft = fm.beginTransaction();
               ft.replace(R.id.fragment_container, fragment);
               ft.commit();
           case 3:
               fragment = new PassFragment();
               fm = getSupportFragmentManager();
               ft = fm.beginTransaction();
               ft.replace(R.id.fragment_container, fragment);
               ft.commit();
       }

    }



}
