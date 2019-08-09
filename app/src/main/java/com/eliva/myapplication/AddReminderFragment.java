package com.eliva.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import com.eliva.myapplication.db.AppDatabase;
import com.eliva.myapplication.db.model.ReminderBO;
import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddReminderFragment extends DialogFragment {

    @BindView(R.id.addReminderHeader)
    TextInputEditText TitleText;
//    @BindView(R.id.addReminderDate)
//    TextInputEditText DateField;

    @BindView(R.id.reminderDatePicker)
    SingleDateAndTimePicker sdp;

    @BindView(R.id.reminderSaveButton)
    MaterialButton buttonAddReminder;

    Date dpDate;

    AppDatabase database;

    ReminderBO reminderBO = null;

    public AddReminderFragment(ReminderBO bo) {
        this.reminderBO = bo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_reminder, container, false);
        database = AppDatabase.getDatabaseInstance(v.getContext());
        getDialog().setCanceledOnTouchOutside(false);
        ButterKnife.bind(this, v);
        if (reminderBO != null) {
            TitleText.setText(reminderBO.getTitle());
//            Calendar c = new GregorianCalendar();
//            c.setTime(reminderBO.getRemindDate());
//            sdp.selectDate(c);
        }
        return v;
    }


    @OnClick(R.id.reminderSaveButton)
    public void onViewClicked() {
        ReminderBO mReminder = new ReminderBO();
        mReminder.setTitle(TitleText.getText().toString());
        mReminder.setRemindDate(sdp.getDate());
        database.reminderDao().insertReminder(mReminder);
        getFragmentManager().beginTransaction().remove(this).commit();
    }

//    @OnClick(R.id.reminderDatePickerButton)
//    public void onDatePickerClicked() {
//
//        new SingleDateAndTimePickerDialog.Builder(getContext())
//                //.bottomSheet()
//                //.curved()
//                //.minutesStep(15)
//                //.displayHours(false)
//                //.displayMinutes(false)
//                //.todayText("aujourd'hui")
//                .curved()
//                .displayListener(new SingleDateAndTimePickerDialog.DisplayListener() {
//                    @Override
//                    public void onDisplayed(SingleDateAndTimePicker picker) {
//                        //dpDate = picker.getDate();
//                    }
//                })
//                .title("Tarih Seçiniz:")
//                .listener(new SingleDateAndTimePickerDialog.Listener(){
//                    @Override
//                    public void onDateSelected(Date date) {
//                        DateField.setText(DateConverter.dateToTimestamp(date).toString());
//                    }
//                }).display();
//
//    }

    @Override
    public void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
