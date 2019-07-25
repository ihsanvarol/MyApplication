package com.eliva.myapplication.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "notes")
public class NoteBO {

    @PrimaryKey(autoGenerate = true)
    private int logicalRef;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "noteLines")
    private String mNoteLines;

    @ColumnInfo(name = "created_at")
    private Date mCreatedAt;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmNoteLines() {
        return mNoteLines;
    }

    public void setmNoteLines(String mNoteLines) {
        this.mNoteLines = mNoteLines;
    }

    public Date getmCreatedAt() {
        return mCreatedAt;
    }

    public void setmCreatedAt(Date mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    public int getLogicalRef() {
        return logicalRef;
    }

    public void setLogicalRef(int logicalRef) {
        this.logicalRef = logicalRef;
    }

    public NoteBO(String mTitle, String mNoteLines, Date mCreatedAt) {
        this.mTitle = mTitle;
        this.mNoteLines = mNoteLines;
        this.mCreatedAt = mCreatedAt;
    }

}

