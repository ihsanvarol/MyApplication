package com.eliva.myapplication.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eliva.myapplication.db.model.PassesBO;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface PassesDAO {


    @Query("SELECT * FROM passes")
    List<PassesBO> getAll();

    @Insert(onConflict = REPLACE)
    void insertPass(PassesBO mPass);

    @Insert
    void insertAllPasses(PassesBO... mPassesList);

    @Delete
    void delete(PassesBO mPasses);

    @Update
    void updatePass(PassesBO mPass);

    @Query("SELECT * FROM passes WHERE logicalRef = :uId")
    PassesBO getPassById(int uId);


    @Query("SELECT * FROM passes WHERE logicalRef IN (:PassesIds)")
    List<PassesBO> loadAllByIds(int[] PassesIds);

    @Query("SELECT * FROM passes")
    LiveData<List<PassesBO>> getAllPasses();

}


