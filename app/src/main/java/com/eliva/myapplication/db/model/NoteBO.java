package com.eliva.myapplication.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.eliva.myapplication.utils.DateConverter;

import java.util.Date;

@Entity(tableName = "notes")
@TypeConverters({DateConverter.class})
public class NoteBO {

    @PrimaryKey(autoGenerate = true)
    private int logicalRef;

    @ColumnInfo(name = "title")
    private String Title;

    @ColumnInfo(name = "noteLines")
    private String NoteLines;


    @ColumnInfo(name = "created_at")
    private Date CreatedAt;


    public NoteBO() {
    }

    @Ignore
    public NoteBO(String title, String lines) {
        this.Title = title;
        this.NoteLines = lines;
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

    public String getNoteLines() {
        return NoteLines;
    }

    public void setNoteLines(String noteLines) {
        NoteLines = noteLines;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }


}

