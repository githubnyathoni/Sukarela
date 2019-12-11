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

public class CariRelawanActivity extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    // variable fields EditText dan Button
    private Button btSubmit;
    private EditText etNamadepan;
    private EditText etNamabelakang;
    private EditText etEmail;
    private EditText etNohp;
    private EditText etPassword;
    private EditText etKonfirmasipassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_relawan);

        // inisialisasi fields EditText dan Button
        etNamadepan = (EditText) findViewById(R.id.namadepan);
        etNamabelakang = (EditText) findViewById(R.id.namabelakang);
        etEmail = (EditText) findViewById(R.id.email);
        etNohp = (EditText) findViewById(R.id.nohp);
        etPassword = (EditText) findViewById(R.id.password);
        etKonfirmasipassword = (EditText) findViewById(R.id.konfirmasipassword);
        btSubmit = (Button) findViewById(R.id.daftar);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        //bagian input data
        // kode yang dipanggil ketika tombol Submit diklik
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty(etNamadepan.getText().toString()) && !isEmpty(etNamabelakang.getText().toString()) && !isEmpty(etEmail.getText().toString()) && !isEmpty(etNohp.getText().toString()) && !isEmpty(etPassword.getText().toString()) && !isEmpty(etKonfirmasipassword.getText().toString()))
                    submitRegistrasi(new RegistrasiOrganisasi(etNamadepan.getText().toString(), etNamabelakang.getText().toString(), etEmail.getText().toString(), etNohp.getText().toString(), etPassword.getText().toString(), etKonfirmasipassword.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.daftar), "Data tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etNamadepan.getWindowToken(), 0);
            }
        });
        //bagian input data
    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void submitRegistrasi(RegistrasiOrganisasi registrasi) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("Registrasi organisasi 1").push().setValue(registrasi).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNamadepan.setText("");
                etNamabelakang.setText("");
                etEmail.setText("");
                etNohp.setText("");
                etPassword.setText("");
                etKonfirmasipassword.setText("");
                Snackbar.make(findViewById(R.id.daftar), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(CariRelawanActivity.this, CariRelawan2Activity.class));
            }
        });
    }
}
