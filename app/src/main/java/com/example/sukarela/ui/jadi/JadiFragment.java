package com.example.sukarela.ui.jadi;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sukarela.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JadiFragment extends Fragment {


    public JadiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadi, container, false);
    }

}
