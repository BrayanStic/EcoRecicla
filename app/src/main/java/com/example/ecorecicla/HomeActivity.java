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

        Intent categoria=new Intent(getApplicationContext(), CategoriaActivity.class);
        Intent estadist=new Intent(getApplicationContext(), EstadisticaActivity.class);
        Intent conjo=new Intent(getApplicationContext(),ConsejosActivity.class);
        Intent salir=new Intent(getApplicationContext(),MainActivity.class);

        categ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(categoria);
            }
        });

        estd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(estadist);
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