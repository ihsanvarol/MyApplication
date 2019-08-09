package com.eliva.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eliva.myapplication.adapters.RemindersRCAdapter;
import com.eliva.myapplication.db.AppDatabase;
import com.eliva.myapplication.db.model.ReminderBO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class ReminderFragment extends Fragment implements RemindersRCAdapter.Callback {

    RecyclerView mRecyclerView;

    AppDatabase database;
    RemindersRCAdapter mReminderRCAdapter;
    LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.reminderfragmentlayout, container, false);
        mRecyclerView = v.findViewById(R.id.rc_reminder_view);
        FloatingActionButton fab = v.findViewById(R.id.reminder_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogReminder(null);
            }
        });

        ButterKnife.bind(v);
        database = AppDatabase.getDatabaseInstance(v.getContext());
        setUp(v);
        return v;
    }

    private void setUp(View v) {
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mReminderRCAdapter = new RemindersRCAdapter(new ArrayList<ReminderBO>());
        mReminderRCAdapter.setCallback(this);
        // prepareDemoContent();
        mRecyclerView.setAdapter(mReminderRCAdapter);
        database.reminderDao().getAllReminders().observe(this, reminders -> mReminderRCAdapter.setData(reminders));

    }

    private void showDialogReminder(ReminderBO mReminderBO) {
        AddReminderFragment reminder = new AddReminderFragment(mReminderBO);
        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("replaceFragB");
        reminder.show(getFragmentManager(), "Add Reminder");
    }

    @Override
    public void onDeleteClick(ReminderBO mReminderBO) {
        database.reminderDao().delete(mReminderBO);
    }

    @Override
    public void onUpdateClick(ReminderBO mReminderBO) {
        showDialogReminder(mReminderBO);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        AppDatabase.destroyInstance();
    }

}
