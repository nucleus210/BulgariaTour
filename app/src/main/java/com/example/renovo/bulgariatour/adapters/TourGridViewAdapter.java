package com.example.renovo.bulgariatour.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.renovo.bulgariatour.R;

public class TourGridViewAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;

    public TourGridViewAdapter(Context context) {
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    class Holder {
        TextView os_text;
        ImageView os_img;
    }

    // create a new ImageView for each item referenced by the Adapter
    @SuppressLint({"ViewHolder", "InflateParams"})
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_layout, null);
        holder.os_text = rowView.findViewById(R.id.os_texts);
        holder.os_img = rowView.findViewById(R.id.os_images);
        holder.os_text.setText(mTextByIds[position]);
        holder.os_img.setImageResource(mThumbIds[position]);
        return rowView;
    }

    // references to our images
    private final Integer[] mThumbIds = {
            R.drawable.burgas_01,
            R.drawable.bulgaria_pirin,
            R.drawable.bulgaria_rila,
            R.drawable.sofia_01,
            R.drawable.plovdiv_01,
            R.drawable.rila_01
    };
    // references to our images
    private final Integer[] mTextByIds = {
            R.string.bourgas,
            R.string.pirin,
            R.string.rila,
            R.string.sofia,
            R.string.plovdiv,
            R.string.varna
    };
}