package com.eliva.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.eliva.myapplication.R;
import com.eliva.myapplication.db.model.NoteBO;
import com.eliva.myapplication.viewholders.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NotesRCAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Callback mCallback;
    private List<NoteBO> mNoteList;

    public NotesRCAdapter(List<NoteBO> notesList) {
        mNoteList = notesList;
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
                LayoutInflater.from(parent.getContext()).inflate(R.layout.noteline, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mNoteList != null && mNoteList.size() > 0) {
            return mNoteList.size();
        } else {
            return 0;
        }
    }

    public interface Callback {
        void onDeleteClick(NoteBO mNoteBO);
    }

    public void addItems(List<NoteBO> notesList) {
        mNoteList = notesList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.nlDelete)
        ImageView imageViewDelete;

        @BindView(R.id.nlTitle)
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

            final NoteBO mNote = mNoteList.get(position);

            if (mNote.getTitle() != null) {
                textViewName.setText(mNote.getTitle());
            }

            imageViewDelete.setOnClickListener(v -> mCallback.onDeleteClick(mNote));
        }
    }
}