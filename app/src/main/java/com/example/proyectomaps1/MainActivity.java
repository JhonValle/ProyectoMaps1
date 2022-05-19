package com.example.proyectomaps1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnTipos,btnUbicacion,btnSitios,btnRutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSitios = (Button) findViewById(R.id.BtnSitioss);
        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LugaresTuristicosCusco.class);
                startActivity(intent);
            }
        });
        btnUbicacion = (Button) findViewById(R.id.BtnUbicacionn);
        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MaravillasAntiguas.class);
                startActivity(intent);
            }
        });
        btnTipos = (Button) findViewById(R.id.BtnTiposs);
        btnTipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MaravillasModernas.class);
                startActivity(intent);
            }
        });
        btnRutas = (Button) findViewById(R.id.BtnRutas);
        btnRutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsRutas.class);
                startActivity(intent);
            }
        });

    }
}