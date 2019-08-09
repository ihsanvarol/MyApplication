package com.eliva.myapplication.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.eliva.myapplication.utils.DateConverter;

import java.util.Date;

@Entity(tableName = "reminders")
@TypeConverters({DateConverter.class})
public class ReminderBO {

    @PrimaryKey(autoGenerate = true)
    private int logicalRef;

    @ColumnInfo(name = "title")
    private String Title;


    @ColumnInfo(name = "remindDate")
    private Date RemindDate;

    @ColumnInfo(name = "created_at")
    private Date CreatedAt;


    public ReminderBO() {
    }

    @Ignore
    public ReminderBO(String title, Date remindDate) {
        this.Title = title;
        this.RemindDate = remindDate;
    }

    public int getLogicalRef() {
        return logicalRef;
    }

    public void setLogicalRef(int logicalRef) {
        this.logicalRef = logicalRef;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getRemindDate() {
        return RemindDate;
    }

    public void setRemindDate(Date remindDate) {
        RemindDate = remindDate;
    }

}

