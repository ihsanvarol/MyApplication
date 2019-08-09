package com.eliva.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.eliva.myapplication.R;
import com.eliva.myapplication.db.model.ReminderBO;
import com.eliva.myapplication.viewholders.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RemindersRCAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Callback mCallback;
    private List<ReminderBO> mRemindersList;

    public RemindersRCAdapter(List<ReminderBO> reminderList) {
        mRemindersList = reminderList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.reminderline, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mRemindersList != null && mRemindersList.size() > 0) {
            return mRemindersList.size();
        } else {
            return 0;
        }
    }

    public interface Callback {
        void onDeleteClick(ReminderBO mReminderBO);

        void onUpdateClick(ReminderBO mReminderBO);
    }

    public void addItems(List<ReminderBO> reminderList) {
        mRemindersList = reminderList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.remLineDelete)
        ImageView imageViewDelete;

        @BindView(R.id.remLineUpdate)
        ImageView imageViewUpdate;

        @BindView(R.id.remLineTitle)
        TextView textViewName;


        public ViewHolder(View nlView) {
            super(nlView);
            ButterKnife.bind(this, nlView);

        }

        protected void clear() {
            textViewName.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final ReminderBO mReminder = mRemindersList.get(position);

            if (mReminder.getTitle() != null) {
                textViewName.setText(mReminder.getTitle());
            }

            imageViewDelete.setOnClickListener(v -> mCallback.onDeleteClick(mReminder));
            imageViewUpdate.setOnClickListener(v -> mCallback.onUpdateClick(mReminder));
        }
    }

    public void setData(List<ReminderBO> newData) {
        this.mRemindersList = newData;
        notifyDataSetChanged();
    }

}