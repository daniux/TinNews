package com.tinnews.tinnews.profile;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tinnews.tinnews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TinProfileFragment extends Fragment {


    public static TinProfileFragment newInstance() {

        Bundle args = new Bundle();

        TinProfileFragment fragment = new TinProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tin_profile, container, false);
    }

}
