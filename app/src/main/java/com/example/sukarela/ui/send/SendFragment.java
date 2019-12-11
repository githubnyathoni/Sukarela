package com.example.sukarela.ui.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.sukarela.Login;
import com.example.sukarela.R;
import com.example.sukarela.Register;

public class SendFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_send, container, false);

        Button coba = (Button) view.findViewById(R.id.coba);
        Button coba2 = (Button) view.findViewById(R.id.coba2);
        coba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Register.class);
                startActivity(intent);
            }
        });
        coba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Login.class);
                startActivity(intent);
            }
        });

        return view;
    }
}