package com.example.pakarnila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView diagnosiss, penyakit, about, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diagnosiss = findViewById(R.id.diagnosiss);
        penyakit = findViewById(R.id.penyakit);
        about = findViewById(R.id.about);
        exit = findViewById(R.id.exit);

        diagnosiss.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PakarMysql.class);
            intent.putExtra("id","G001");
            startActivity(intent);
            finish();
        });

        penyakit.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, daftarpenyakit.class);
            finish();
            startActivity(intent);
        });

        about.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, tentangkami.class);
            finish();
            startActivity(intent);
        });

        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                moveTaskToBack(true);

                //membuat method tombol keluar dari aplikasi
            }
        });

    }
}