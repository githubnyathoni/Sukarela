package com.example.sukarela;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class CariRelawan2Activity extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    private Button selanjutnya, uploadgambar;
    private ImageView imageView;
    private EditText etNamaorganisasi;
    private EditText etJenisorganisasi;
    private EditText etDeskripsi;
    private Spinner spFokusutama;
    private Spinner spFokustambahan;

    private Uri filePath;

    private final int PICK_IMAGE_REQUEST = 71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_relawan2);

        //Initialize Views
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        uploadgambar = (Button) findViewById(R.id.uploadgambar);
        selanjutnya = (Button) findViewById(R.id.selanjutnya);
        imageView = (ImageView) findViewById(R.id.imgView);
        etNamaorganisasi = (EditText) findViewById(R.id.namaorganisasi);
        etJenisorganisasi = (EditText) findViewById(R.id.jenisorganisasi);
        etDeskripsi = (EditText) findViewById(R.id.deskripsi);
        spFokusutama = (Spinner) findViewById(R.id.fokusutama);
        spFokustambahan = (Spinner) findViewById(R.id.fokustambahan);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        //bagian input data
        // kode yang dipanggil ketika tombol Submit diklik
        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
                if (!isEmpty(etNamaorganisasi.getText().toString()) && !isEmpty(etJenisorganisasi.getText().toString()) && !isEmpty(etDeskripsi.getText().toString()))
                    submitRegistrasiOrganisasi2(new RegistrasiOrganisasi2(etNamaorganisasi.getText().toString(), etJenisorganisasi.getText().toString(), etDeskripsi.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.selanjutnya), "Data barang tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etNamaorganisasi.getWindowToken(), 0);
            }
        });
        //bagian input data

        uploadgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });
    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void submitRegistrasiOrganisasi2(RegistrasiOrganisasi2 registrasi) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("Registrasi Organisasi 2").push().setValue(registrasi).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNamaorganisasi.setText("");
                etJenisorganisasi.setText("");
                etDeskripsi.setText("");
                Snackbar.make(findViewById(R.id.selanjutnya), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(CariRelawan2Activity.this, CariRelawan3Activity.class));
            }
        });
    }

    //fungsi button uploadgambar
    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //Firebase
    FirebaseStorage storage;
    StorageReference storageReference;


    //fungsi button selanjutnya
    private void uploadImage() {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(CariRelawan2Activity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(CariRelawan2Activity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }
}
