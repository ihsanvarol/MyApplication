package com.eliva.myapplication.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.eliva.myapplication.utils.DateConverter;

import java.util.Date;

@Entity(tableName = "passes")
@TypeConverters({DateConverter.class})
public class PassesBO {

    @PrimaryKey(autoGenerate = true)
    private int logicalRef;

    @ColumnInfo(name = "title")
    private String Title;

    @ColumnInfo(name = "username")
    private String UserName;

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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    @ColumnInfo(name = "email")
    private String EMail;

    @ColumnInfo(name = "password")
    private String Password;

    @ColumnInfo(name = "created_at")
    private Date CreatedAt;


    public PassesBO() {
    }

    @Ignore
    public PassesBO(String title, String email, String username, String password) {
        this.Title = title;
        this.UserName = username;
        this.Password = password;
        this.EMail = email;
    }
}


