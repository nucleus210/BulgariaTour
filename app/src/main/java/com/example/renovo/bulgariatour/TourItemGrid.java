package com.example.renovo.bulgariatour;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.renovo.bulgariatour.adapters.TourGridViewAdapter;
import com.example.renovo.bulgariatour.viewmodel.DataHolderModel;

import java.util.Objects;

public class TourItemGrid extends Fragment implements AdapterView.OnItemClickListener {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String TAG = "GridView";
    private Context mContext;
    @SuppressWarnings("unused")
    OnGridFragmentListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TourItemGrid() {
    }

    @SuppressWarnings("unused")
    public static TourItemGrid newInstance(int columnCount) {
        TourItemGrid fragment = new TourItemGrid();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        Log.d(TAG, "OnCreate");
        if (getArguments() != null) {
            getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.grid_item, container, false);
        GridView mControlGridView = view.findViewById(R.id.remote_control_grid_view);
        mControlGridView.setAdapter(new TourGridViewAdapter(Objects.requireNonNull(getActivity())));
        mControlGridView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.remote_control_grid_view) {
            String pos = Integer.toString(position);
            ObjectAnimator picMoveX = ObjectAnimator.ofFloat(parent
                    .getChildAt(Integer.parseInt(pos)), "alpha", 100f, 0f);
            picMoveX.setDuration(1000);
            ObjectAnimator fadeIn = ObjectAnimator.ofFloat(parent
                    .getChildAt(Integer.parseInt(pos)), "alpha", 0f, 100f);
            fadeIn.setDuration(2000);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(picMoveX).with(fadeIn);
            animatorSet.start();
            switch (position) {

                case 0:
                    DataHolderModel.getInstance(mContext)
                            .setImageRes(CitesResourceDescriptor.imageDescriptorBurgas);
                    DataHolderModel.getInstance(mContext)
                            .setDataDesc(CitesResourceDescriptor.detailDescriptorBurgas);
                    DataHolderModel.getInstance(mContext)
                            .setTitleDesc(CitesResourceDescriptor.titleDescriptorBurgas);

                    Intent intentBurgas = new Intent(getActivity(), PlacesListActivity.class);
                    startActivity(intentBurgas);
                    break;

                case 1:
                    DataHolderModel.getInstance(mContext)
                            .setImageRes(CitesResourceDescriptor.imageDescriptorPirin);
                    DataHolderModel.getInstance(mContext)
                            .setDataDesc(CitesResourceDescriptor.detailDescriptorPirin);
                    DataHolderModel.getInstance(mContext)
                            .setTitleDesc(CitesResourceDescriptor.titleDescriptorPirin);
                    Intent intentPirin = new Intent(getActivity(), PlacesListActivity.class);
                    startActivity(intentPirin);
                    break;

                case 2:
                    DataHolderModel.getInstance(mContext)
                            .setImageRes(CitesResourceDescriptor.imageDescriptorRila);
                    DataHolderModel.getInstance(mContext)
                            .setDataDesc(CitesResourceDescriptor.detailDescriptorRila);
                    DataHolderModel.getInstance(mContext)
                            .setTitleDesc(CitesResourceDescriptor.titleDescriptorRila);
                    Intent intentRila = new Intent(getActivity(), PlacesListActivity.class);
                    startActivity(intentRila);
                    break;
                case 3:
                    DataHolderModel.getInstance(mContext)
                            .setImageRes(CitesResourceDescriptor.imageDescriptorSofia);
                    DataHolderModel.getInstance(mContext)
                            .setDataDesc(CitesResourceDescriptor.detailDescriptorSofia);
                    DataHolderModel.getInstance(mContext)
                            .setTitleDesc(CitesResourceDescriptor.titleDescriptorSofia);
                    Intent intentSofia = new Intent(getActivity(), PlacesListActivity.class);
                    startActivity(intentSofia);
                    break;
                case 4:
                    DataHolderModel.getInstance(mContext)
                            .setImageRes(CitesResourceDescriptor.imageDescriptorPlovdiv);
                    DataHolderModel.getInstance(mContext)
                            .setDataDesc(CitesResourceDescriptor.detailDescriptorPlovdiv);
                    DataHolderModel.getInstance(mContext)
                            .setTitleDesc(CitesResourceDescriptor.titleDescriptorPlovdiv);
                    Intent intentPlovdiv = new Intent(getActivity(), PlacesListActivity.class);
                    startActivity(intentPlovdiv);
                    break;
            }
        }
    }

//------------------------------------------------------------------------------------------------//

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
//------------------------------------------------------------------------------------------------//
    @SuppressWarnings("unused")
    public interface OnGridFragmentListener {void onGridFragmentListener();}
}
