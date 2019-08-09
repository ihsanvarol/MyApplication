package com.eliva.myapplication.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eliva.myapplication.db.model.ClientsBO;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ClientsDAO {


    @Query("SELECT * FROM clients")
    List<ClientsBO> getAll();

    @Insert(onConflict = REPLACE)
    void insertClient(ClientsBO mClient);

    @Insert
    void insertAllClients(ClientsBO... mClientsList);

    @Delete
    void delete(ClientsBO mClient);

    @Update
    void updateClient(ClientsBO mClient);

    @Query("SELECT * FROM clients WHERE logicalRef = :uId")
    ClientsBO getClientById(int uId);


    @Query("SELECT * FROM clients WHERE logicalRef IN (:clientIds)")
    List<ClientsBO> loadAllByIds(int[] clientIds);

    @Query("SELECT * FROM clients")
    LiveData<List<ClientsBO>> getAllClients();

}


