package com.eliva.myapplication.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eliva.myapplication.db.model.ReminderBO;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface RemindersDAO {


    @Query("SELECT * FROM reminders")
    List<ReminderBO> getAll();

    @Insert(onConflict = REPLACE)
    void insertReminder(ReminderBO mReminder);

    @Insert
    void insertAllReminders(ReminderBO... mReminderList);

    @Delete
    void delete(ReminderBO mReminder);

    @Update
    void updateReminder(ReminderBO mReminder);

    @Query("SELECT * FROM reminders WHERE logicalRef = :uId")
    ReminderBO getReminderById(int uId);


    @Query("SELECT * FROM reminders WHERE logicalRef IN (:reminderIds)")
    List<ReminderBO> loadAllByIds(int[] reminderIds);

    @Query("SELECT * FROM reminders")
    LiveData<List<ReminderBO>> getAllReminders();

}


