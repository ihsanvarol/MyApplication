package com.eliva.myapplication.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eliva.myapplication.db.model.SessionsBO;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SessionsDAO {


    @Query("SELECT * FROM sessions")
    List<SessionsBO> getAll();

    @Insert(onConflict = REPLACE)
    void insertSession(SessionsBO mSessions);

    @Insert
    void insertAllSessions(SessionsBO... mSessionsList);

    @Delete
    void delete(SessionsBO mSession);

    @Update
    void updateSession(SessionsBO mSession);

    @Query("SELECT * FROM sessions WHERE logicalRef = :uId")
    SessionsBO getSessionById(int uId);


    @Query("SELECT * FROM sessions WHERE logicalRef IN (:sessionIds)")
    List<SessionsBO> loadAllByIds(int[] sessionIds);

    @Query("SELECT * FROM sessions")
    LiveData<List<SessionsBO>> getAllSessions();

}


