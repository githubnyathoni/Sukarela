package com.example.sukarela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CariRelawan3Activity extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    // variable fields EditText dan Button
    private Button btSelanjutnya;
    private EditText etKota;
    private EditText etKabupaten;
    private EditText etAlamat;
    private EditText etWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_relawan3);

        // inisialisasi fields EditText dan Button
        etKota = (EditText) findViewById(R.id.kota);
        etKabupaten = (EditText) findViewById(R.id.kabupaten);
        etAlamat = (EditText) findViewById(R.id.alamat);
        etWebsite= (EditText) findViewById(R.id.website);
        btSelanjutnya = (Button) findViewById(R.id.selanjutnya);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        //bagian input data
        // kode yang dipanggil ketika tombol Submit diklik
        btSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty(etKota.getText().toString()) && !isEmpty(etKabupaten.getText().toString()) && !isEmpty(etAlamat.getText().toString()) && !isEmpty(etWebsite.getText().toString()))
                    submitRegistrasi3(new RegistrasiOrganisasi3(etKota.getText().toString(), etKabupaten.getText().toString(), etAlamat.getText().toString(), etWebsite.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.selanjutnya), "Data tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etKota.getWindowToken(), 0);
            }
        });
        //bagian input data
    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void submitRegistrasi3(RegistrasiOrganisasi3 registrasi) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("Registrasi organisasi 1").push().setValue(registrasi).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etKota.setText("");
                etKabupaten.setText("");
                etAlamat.setText("");
                etWebsite.setText("");
                Snackbar.make(findViewById(R.id.selanjutnya), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(CariRelawan3Activity.this, CariRelawan4Activity.class));
            }
        });
    }
}
