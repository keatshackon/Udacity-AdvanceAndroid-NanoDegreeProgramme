package com.keatssalazar.andriod_me.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.keatssalazar.andriod_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private static final String TAG = BodyPartFragment.class.getSimpleName();
    private static final String IMAGE_ID_LIST = "image_id";
    private static final String LIST_INDEX = "list_index";


    private List<Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }


        if (mImageIds != null) {

            imageView.setImageResource(mImageIds.get(mListIndex));

        } else {
            Log.v(TAG, "this Fragment Has Null List Of image Id's");
        }


        return rootView;
    }

    public void setImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX, mListIndex);
    }
}
