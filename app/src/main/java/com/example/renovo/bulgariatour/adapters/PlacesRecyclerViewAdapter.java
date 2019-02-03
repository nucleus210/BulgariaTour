package com.example.renovo.bulgariatour.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.renovo.bulgariatour.R;
import com.example.renovo.bulgariatour.PlacesListFragment.OnListFragmentInteractionListener;
import com.example.renovo.bulgariatour.places.PlacesContent.PlaceItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class PlacesRecyclerViewAdapter extends RecyclerView.Adapter<PlacesRecyclerViewAdapter.ViewHolder> {
    private final List<PlaceItem> mValues;
    private final OnListFragmentInteractionListener mListener;


    public PlacesRecyclerViewAdapter(List<PlaceItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_places_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mContentView.setText(mValues.get(position).content);
        holder.mImageView.setImageResource(mValues.get(position).mImage);

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onListFragmentInteraction(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mContentView;
        final ImageView mImageView;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = view.findViewById(R.id.content_view);
            mImageView = view.findViewById(R.id.item_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
