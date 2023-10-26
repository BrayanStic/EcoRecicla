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

        Intent pantallaReg=new Intent(getApplicationContext(), RegistroItemActivity.class);
        Intent pantallaPrin=new Intent(getApplicationContext(), HomeActivity.class);
        Intent pantallaAtras=new Intent(getApplicationContext(), HomeActivity.class);

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaReg);
            }
        });

        papel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaReg);
            }
        });

        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaReg);
            }
        });

        plastico1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaReg);
            }
        });

        carton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaReg);
            }
        });

        carton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pantallaReg);
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