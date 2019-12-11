package com.example.sukarela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CariRelawan4Activity extends AppCompatActivity {

    private Button btSelanjutnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_relawan4);

        btSelanjutnya = (Button) findViewById(R.id.selanjutnya);
        btSelanjutnya.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CariRelawan4Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
