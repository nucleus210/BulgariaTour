package com.example.renovo.bulgariatour.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.renovo.bulgariatour.HistoryItemFragment.OnHistoryInteractionListener;
import com.example.renovo.bulgariatour.R;
import com.example.renovo.bulgariatour.history.HistoryContent.HistoryItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link HistoryItem} and makes a call to the
 * specified {@link OnHistoryInteractionListener}.
 */

public class HistoryRecyclerViewAdapter extends
        RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder> {

    private final List<HistoryItem> mValues;

    public HistoryRecyclerViewAdapter(List<HistoryItem> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mTitle.setText(mValues.get(position).title);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mLicence.setText(mValues.get(position).license);
        holder.mImage.setImageResource(mValues.get(position).image);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mImage;
        final TextView mTitle;
        final TextView mLicence;
        final TextView mContentView;


        ViewHolder(View view) {
            super(view);
            mTitle = view.findViewById(R.id.title_view);
            mContentView = view.findViewById(R.id.content_view);
            mLicence = view.findViewById(R.id.license_content);
            mImage = view.findViewById(R.id.history_image);
        }
    }
}
