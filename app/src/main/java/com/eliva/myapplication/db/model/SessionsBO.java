package com.eliva.myapplication.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.eliva.myapplication.utils.DateConverter;

import java.util.Date;

@Entity(tableName = "sessions")
@TypeConverters({DateConverter.class})
public class SessionsBO {

    @PrimaryKey(autoGenerate = true)
    private int logicalRef;

    @ColumnInfo(name = "clientRef")
    private int ClientRef;

    @ColumnInfo(name = "sessionDate")
    private Date SessionDate;

    @ColumnInfo(name = "online")
    private int WebTherapy;

    @ColumnInfo(name = "status")
    private int Status;

    @ColumnInfo(name = "sessionNotes")
    private String SessionNotes;

    @ColumnInfo(name = "priceTaken")
    private int PriceTaken;

    @ColumnInfo(name = "price")
    private int Price;

    public int getLogicalRef() {
        return logicalRef;
    }

    public void setLogicalRef(int logicalRef) {
        this.logicalRef = logicalRef;
    }

    public int getClientRef() {
        return ClientRef;
    }

    public void setClientRef(int clientRef) {
        ClientRef = clientRef;
    }

    public Date getSessionDate() {
        return SessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        SessionDate = sessionDate;
    }

    public int getWebTherapy() {
        return WebTherapy;
    }

    public void setWebTherapy(int webTherapy) {
        WebTherapy = webTherapy;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getSessionNotes() {
        return SessionNotes;
    }

    public void setSessionNotes(String sessionNotes) {
        SessionNotes = sessionNotes;
    }

    public int getPriceTaken() {
        return PriceTaken;
    }

    public void setPriceTaken(int priceTaken) {
        PriceTaken = priceTaken;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    @ColumnInfo(name = "created_at")
    private Date CreatedAt;

    @Ignore
    public SessionsBO() {
    }
}


