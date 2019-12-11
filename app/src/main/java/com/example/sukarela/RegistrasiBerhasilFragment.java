package com.example.sukarela;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RegistrasiBerhasilFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registrasi_berhasil, container, false);


        Button sementara = (Button)view.findViewById(R.id.sementara);
        sementara.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId () == R.id.sementara){
            BuatAktivitasOrganisasiFragment mInfoFragment = new BuatAktivitasOrganisasiFragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.fragment_container, mInfoFragment, BuatAktivitasOrganisasiFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }

    }


}
