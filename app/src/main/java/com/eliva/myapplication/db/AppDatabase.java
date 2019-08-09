package com.eliva.myapplication.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.eliva.myapplication.db.dao.NotesDAO;
import com.eliva.myapplication.db.dao.PassesDAO;
import com.eliva.myapplication.db.dao.RemindersDAO;
import com.eliva.myapplication.db.model.NoteBO;
import com.eliva.myapplication.db.model.PassesBO;
import com.eliva.myapplication.db.model.ReminderBO;

@Database(entities = {NoteBO.class, ReminderBO.class, PassesBO.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase mInstance;
    private static final String DATABASE_NAME = "SYNCAP";

    public abstract NotesDAO notesDao();

    public abstract RemindersDAO reminderDao();

    public abstract PassesDAO passesDAO();

    public synchronized static AppDatabase getDatabaseInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }


    public static void destroyInstance() {
        mInstance = null;
    }

}