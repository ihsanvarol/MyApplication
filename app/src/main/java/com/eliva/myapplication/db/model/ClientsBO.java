package com.eliva.myapplication.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.eliva.myapplication.utils.DateConverter;

import java.util.Date;

@Entity(tableName = "clients")
@TypeConverters({DateConverter.class})
public class ClientsBO {

    public int getLogicalRef() {
        return logicalRef;
    }

    public void setLogicalRef(int logicalRef) {
        this.logicalRef = logicalRef;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getWebTherapy() {
        return WebTherapy;
    }

    public void setWebTherapy(int webTherapy) {
        WebTherapy = webTherapy;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String reference) {
        Reference = reference;
    }

    public int getDefaultPrice() {
        return DefaultPrice;
    }

    public void setDefaultPrice(int defaultPrice) {
        DefaultPrice = defaultPrice;
    }

    @PrimaryKey(autoGenerate = true)
    private int logicalRef;

    @ColumnInfo(name = "name")
    private String Name;

    @ColumnInfo(name = "surname")
    private String Surname;

    @ColumnInfo(name = "email")
    private String Email;

    @ColumnInfo(name = "phone1")
    private String Phone;

    @ColumnInfo(name = "online")
    private int WebTherapy;

    @ColumnInfo(name = "birthDate")
    private Date BirthDate;

    @ColumnInfo(name = "comments")
    private String comments;

    @ColumnInfo(name = "created_at")
    private Date CreatedAt;

    @ColumnInfo(name = "reference")
    private String Reference;

    @ColumnInfo(name = "defaultPrice")
    private int DefaultPrice;

    @Ignore
    public ClientsBO() {
    }
}


