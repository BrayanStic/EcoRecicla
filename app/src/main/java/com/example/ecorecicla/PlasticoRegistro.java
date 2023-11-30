package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ecorecicla.models.Papel;
import com.example.ecorecicla.models.Plastico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class PlasticoRegistro extends AppCompatActivity {

    EditText quantity, price, months;
    Button registerPlastico;
    ImageView home, atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastico_registro);
        quantity = findViewById(R.id.cantidadPlastico);
        price = findViewById(R.id.valorPlastico);
        months = findViewById(R.id.mesPlastico);
        registerPlastico = findViewById(R.id.registerPlastico);

        Intent receive = getIntent();
        String idUser = receive.getStringExtra("idUser");

        home = findViewById(R.id.logoHome);
        atras = findViewById(R.id.atrasFlecha);

        Intent pantallaPrin = new Intent(getApplicationContext(), HomeActivity.class);
        Intent pantallaAtras = new Intent(getApplicationContext(), CategoriaActivity.class);

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

        registerPlastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity.getText().toString().isEmpty() ||
                        price.getText().toString().isEmpty() ||
                        months.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Todos los campos deben estar completos", Toast.LENGTH_LONG).show();
                } else {
                    int quantityPapel = Integer.parseInt(quantity.getText().toString());
                    int pricePapel = Integer.parseInt(price.getText().toString());
                    String monthPapel = months.getText().toString();
                    Papel consume = new Papel(quantityPapel, pricePapel, monthPapel, idUser);
                    savePlastico(consume);
                    cleanView();
                    Toast.makeText(getApplicationContext(),
                            "Registro del consumo exitoso", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void savePlastico (Plastico consume){
        File fileElectricity = new File(getFilesDir(), "electricity.txt");

        try {
            FileWriter writer = new FileWriter(fileElectricity, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
                    consume.getQuantity() + "," +
                            consume.getPrice() + "," +
                            consume.getMonth() + "," +
                            consume.getIdUser()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    public void cleanView () {
        quantity.setText("");
        price.setText("");
        months.setSelection(0);
    }
}