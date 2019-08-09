package com.eliva.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import com.eliva.myapplication.db.AppDatabase;
import com.eliva.myapplication.db.model.NoteBO;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddNoteFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R.id.addNoteHeader)
    TextInputEditText titleText;
    @BindView(R.id.addNoteMemo)
    TextInputEditText linesText;
    @BindView(R.id.noteSaveButton)
    MaterialButton buttonAddNote;


    AppDatabase database;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddNoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_note, container, false);
        database = AppDatabase.getDatabaseInstance(v.getContext());
        ButterKnife.bind(this, v);
        return v;
    }


    @OnClick(R.id.noteSaveButton)
    public void onViewClicked() {
//        if (titleText.getText().toString().trim().isEmpty()) {
//            textInputLayoutFirstName.setError(getString(R.string.error_msg_firstname));
//            return;
//        }
//
//        if (textEmail.getText().toString().trim().isEmpty()) {
//            textInputLayoutEmail.setError(getString(R.string.error_msg_email));
//            return;
//        }
        NoteBO mNote = new NoteBO(titleText.getText().toString(), linesText.getText().toString());
        database.notesDao().insertNote(mNote);
        //getFragmentManager().popBackStack("replaceFragA", 0);
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    @Override
    public void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
