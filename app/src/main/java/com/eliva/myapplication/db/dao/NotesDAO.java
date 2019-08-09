package com.eliva.myapplication.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eliva.myapplication.db.model.NoteBO;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface NotesDAO {


    @Query("SELECT * FROM notes")
    List<NoteBO> getAll();

    @Insert(onConflict = REPLACE)
    void insertNote(NoteBO mNote);

    @Insert
    void insertAllNotes(NoteBO... mNotesList);

    @Delete
    void delete(NoteBO mNote);

    @Update
    void updateNote(NoteBO mNote);

    @Query("SELECT * FROM notes WHERE logicalRef = :uId")
    NoteBO getNoteById(int uId);


    @Query("SELECT * FROM notes WHERE logicalRef IN (:noteIds)")
    List<NoteBO> loadAllByIds(int[] noteIds);

    @Query("SELECT * FROM notes")
    LiveData<List<NoteBO>> getAllNotes();

}


