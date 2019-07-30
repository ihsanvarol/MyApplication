package com.eliva.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eliva.myapplication.adapters.NotesRCAdapter;
import com.eliva.myapplication.db.AppDatabase;
import com.eliva.myapplication.db.model.NoteBO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class NotesFragment extends Fragment implements NotesRCAdapter.Callback {

    RecyclerView mRecyclerView;

    AppDatabase database;
    NotesRCAdapter mNotesAdapter;
    LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.notesfragmentlayout,container,false);
        mRecyclerView = v.findViewById(R.id.rc_notes_view);
        FloatingActionButton fab = v.findViewById(R.id.notes_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNote();
            }
        });

        ButterKnife.bind(v);
        database = AppDatabase.getDatabaseInstance(v.getContext());
        setUp(v);
        return v;
    }

    private void setUp(View v) {
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mNotesAdapter = new NotesRCAdapter(new ArrayList<NoteBO>());
        mNotesAdapter.setCallback(this);
        prepareDemoContent();
        mRecyclerView.setAdapter(mNotesAdapter);

    }

    private void showDialogNote() {
        AddNoteFragment note = new AddNoteFragment();
        note.show(getFragmentManager(), "Add Note");
    }

    @Override
    public void onDeleteClick(NoteBO mNoteBO) {
        database.notesDao().delete(mNoteBO);
        mNotesAdapter.addItems(database.notesDao().getAll());
    }

    private void prepareDemoContent() {
        NoteBO note1 = new NoteBO();
        note1.setTitle("test 1");
        note1.setNoteLines("fsdfsdf");
        NoteBO note2 = new NoteBO();
        note2.setTitle("test 2");
        note2.setNoteLines("fcdsfdsfsdfsdf");
        database.notesDao().insertNote(note1);
        database.notesDao().insertNote(note2);
    }

    @Override
    public void onResume() {
        super.onResume();
        mNotesAdapter.addItems(database.notesDao().getAll());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        AppDatabase.destroyInstance();
    }


}
