package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CategoriaActivity extends AppCompatActivity {

    ImageView papel, plastico, carton, home, atras;
    Button papel1,plastico1,carton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        papel=findViewById(R.id.imageViewPapel);
        plastico=findViewById(R.id.imageViewPlastico);
        carton=findViewById(R.id.imageViewCarton);
        papel1=findViewById(R.id.buttonPapel);
        plastico1=findViewById(R.id.buttonPlastico);
        carton1=findViewById(R.id.buttonCarton);
        home=findViewById(R.id.logoHome);
        atras=findViewById(R.id.atrasFlecha);

        Intent pantallaPapel=new Intent(getApplicationContext(), PapelRegistro.class);
        Intent pantallaPlastico=new Intent(getApplicationContext(), PlasticoRegister.class);
        Intent pantallaCarton= new Intent(getApplicationContext(), CartonRegistro.class);
        Intent pantallaPrin=new Intent(getApplicationContext(), HomeActivity.class);
        Intent pantallaAtras=new Intent(getApplicationContext(), HomeActivity.class);

        Intent receive= getIntent();
        String id= receive.getStringExtra("idUser");

        Intent registerPapel= new Intent(getApplicationContext(),
                PapelRegistro.class);
        registerPapel.putExtra("idUser",id);

        Intent registerPlastico= new Intent(getApplicationContext(),
                PlasticoRegistro.class);
        registerPlastico.putExtra("idUser",id);

        Intent registerCarton= new Intent(getApplicationContext(),
                CartonRegistro.class);
        registerCarton.putExtra("idUser",id);

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaPapel);
            }
        });

        papel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaPapel);
            }
        });

        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaPlastico);
            }
        });

        plastico1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaPlastico);
            }
        });

        carton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaCarton);
            }
        });

        carton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaCarton);
            }
        });

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

    public static class PlasticoRegistro extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_plastico_register);
        }
    }
}