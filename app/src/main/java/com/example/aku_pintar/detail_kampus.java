package com.example.aku_pintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detail_kampus extends AppCompatActivity {

    private TextView maps, alamat1, nama1, jenis1, status1, akredi1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kampus);
        maps = (TextView) findViewById(R.id.maps);
        nama1 = (TextView) findViewById(R.id.nama1);
        alamat1 = (TextView) findViewById(R.id.alamat1);
        jenis1 = (TextView) findViewById(R.id.jenis1);
        status1 = (TextView) findViewById(R.id.status1);
        akredi1 = (TextView) findViewById(R.id.akredi1);

        Intent i = getIntent();

        String nama = i.getStringExtra("Nama ");
        String alamat = i.getStringExtra("Alamat ");
        String jenis = i.getStringExtra("Jenis ");
        String status = i.getStringExtra("Status ");
        String akredi = i.getStringExtra("Akreditas ");



        nama1.setText(nama);
        alamat1.setText(alamat);
        jenis1.setText(jenis);
        status1.setText(status);
        akredi1.setText(akredi);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pindah = new Intent(detail_kampus.this, mapsitb.class);
                startActivity(pindah);

                finish();
            }
        });


    }
}
