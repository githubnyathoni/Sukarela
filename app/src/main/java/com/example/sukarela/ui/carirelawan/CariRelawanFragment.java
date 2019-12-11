package com.example.sukarela.ui.carirelawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sukarela.BuatAktivitasOrganisasiFragment;
import com.example.sukarela.CariRelawan2Fragment;
import com.example.sukarela.CariRelawanActivity;
import com.example.sukarela.R;
import com.example.sukarela.RegistrasiBerhasilFragment;

public class CariRelawanFragment extends Fragment implements View.OnClickListener {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cari_relawan, container, false);

        Button daftar = (Button)view.findViewById(R.id.daftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CariRelawanActivity.class);
                startActivity(intent);
            }
        });

        Button buataktivitas = (Button)view.findViewById(R.id.buataktivitas);
        buataktivitas.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId () == R.id.buataktivitas){
            BuatAktivitasOrganisasiFragment mInfoFragment = new BuatAktivitasOrganisasiFragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.fragment_container, mInfoFragment, BuatAktivitasOrganisasiFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}