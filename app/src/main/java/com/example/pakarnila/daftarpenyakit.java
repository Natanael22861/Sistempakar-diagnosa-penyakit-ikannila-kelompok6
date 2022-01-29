package com.example.pakarnila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class daftarpenyakit extends AppCompatActivity {
    ImageButton trichodina, saprolegniasis, epistylis, bercakmerah, bintik, lernea;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarpenyakit);

        trichodina = findViewById(R.id.trichodina);
        saprolegniasis = findViewById(R.id.saprolegniasis);
        epistylis = findViewById(R.id.epistylis);
        bercakmerah = findViewById(R.id.bercak);
        bintik = findViewById(R.id.bintik);
        lernea = findViewById(R.id.lernea);
        back = findViewById(R.id.back);

        trichodina.setOnClickListener(v -> {
            Intent intent = new Intent(daftarpenyakit.this, trichodina.class);
            finish();
            startActivity(intent);
        });

        saprolegniasis.setOnClickListener(v -> {
            Intent intent = new Intent(daftarpenyakit.this, saprolegniasis.class);
            finish();
            startActivity(intent);
        });

        epistylis.setOnClickListener(v -> {
            Intent intent = new Intent(daftarpenyakit.this, epistyles.class);
            finish();
            startActivity(intent);
        });

        bercakmerah.setOnClickListener(v -> {
            Intent intent = new Intent(daftarpenyakit.this, bercakmerah.class);
            finish();
            startActivity(intent);
        });

        bintik.setOnClickListener(v -> {
            Intent intent = new Intent(daftarpenyakit.this, bintikputih.class);
            finish();
            startActivity(intent);
        });

        lernea.setOnClickListener(v -> {
            Intent intent = new Intent(daftarpenyakit.this, lernea.class);
            finish();
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(daftarpenyakit.this, MainActivity.class);
            finish();
            startActivity(intent);
        });
    }
}