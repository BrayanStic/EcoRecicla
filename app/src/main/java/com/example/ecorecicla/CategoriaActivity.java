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

        Intent receive= getIntent();
        String id= receive.getStringExtra("idUser");

        Intent registerPapel= new Intent(getApplicationContext(),
                PapelRegistro.class);
        registerPapel.putExtra("idUser",id);

        Intent registerPlastico= new Intent(getApplicationContext(),
                PlasticoRegister.class);
        registerPlastico.putExtra("idUser",id);

        Intent registerCarton= new Intent(getApplicationContext(),
                CartonRegistro.class);
        registerCarton.putExtra("idUser",id);

        Intent pantallaPrin=new Intent(getApplicationContext(), HomeActivity.class);
        Intent pantallaAtras=new Intent(getApplicationContext(), HomeActivity.class);



        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerPapel);
            }
        });

        papel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerPapel);
            }
        });

        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerPlastico);
            }
        });

        plastico1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerPlastico);
            }
        });

        carton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerCarton);
            }
        });

        carton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerCarton);
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

 }