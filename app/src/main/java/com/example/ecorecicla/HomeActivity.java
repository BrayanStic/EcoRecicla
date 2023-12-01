package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button categ;
    Button estd;
    Button conj;

    ImageFilterView exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        categ=findViewById(R.id.buttonCateg);
        estd=findViewById(R.id.buttonEst);
        conj=findViewById(R.id.buttonConj);
        exit=findViewById(R.id.imageViewExit);

        Intent receive= getIntent();
        String id= receive.getStringExtra("idUser");

        Intent registerReciclado= new Intent(getApplicationContext(),
                CategoriaActivity.class);
        registerReciclado.putExtra("idUser",id);

        Intent statistics_view= new Intent(getApplicationContext(),
                Stadistic.class);
        statistics_view.putExtra("idUser",id);

        Intent conjo=new Intent(getApplicationContext(),ConsejosActivity.class);
        Intent salir=new Intent(getApplicationContext(),MainActivity.class);

        categ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerReciclado);
            }
        });

        estd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(statistics_view);
            }
        });

        conj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(conjo);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(salir);
            }
        });

    }
}