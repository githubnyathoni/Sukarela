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
public class BuatAktivitasOrganisasiFragment extends Fragment implements View.OnClickListener {


    public BuatAktivitasOrganisasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buat_aktivitas_organisasi, container, false);


        Button buataktifitas = (Button)view.findViewById(R.id.buataktivitas);
        buataktifitas.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId () == R.id.buataktivitas){
            BuatAktivitasOrganisasi2Fragment mInfoFragment = new BuatAktivitasOrganisasi2Fragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.fragment_container, mInfoFragment, BuatAktivitasOrganisasi2Fragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }

    }

}
