package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ConsejosActivity extends AppCompatActivity {

    ImageView home;
    ImageView atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        home=findViewById(R.id.logoHome);
        atras=findViewById(R.id.atrasFlecha);

        Intent pantallaPrin=new Intent(getApplicationContext(), HomeActivity.class);
        Intent pantallaAtras=new Intent(getApplicationContext(), HomeActivity.class);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pantallaPrin);
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pantallaAtras);
            }
        });
    }

    public static class PapelRegistro extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_papel_registro);
        }
    }
}