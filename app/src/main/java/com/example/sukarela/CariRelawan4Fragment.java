package com.example.sukarela;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class CariRelawan4Fragment extends Fragment implements View.OnClickListener {


    public CariRelawan4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cari_relawan4, container, false);

        Button kembali = (Button)view.findViewById(R.id.kembali);
        kembali.setOnClickListener(this);

        Button simpan = (Button)view.findViewById(R.id.simpan);
        simpan.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId () == R.id.kembali){
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStack();
            }
        }

        if (v.getId () == R.id.simpan){
            RegistrasiBerhasilFragment mInfoFragment = new RegistrasiBerhasilFragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.fragment_container, mInfoFragment, RegistrasiBerhasilFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }

    }

}
