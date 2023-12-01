package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecorecicla.models.Carton;
import com.example.ecorecicla.models.Papel;
import com.example.ecorecicla.models.Plastico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Stadistic extends AppCompatActivity {

    ImageView home;
    ImageView atras;

    TextView totalPapel,totalPlastico,totalCarton,dineroRecaudado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadistic);

        home=findViewById(R.id.logoHome);
        atras=findViewById(R.id.atrasFlecha);
        totalPapel=findViewById(R.id.papelReciclado);
        totalPlastico=findViewById(R.id.plasticoReciclado);
        totalCarton=findViewById(R.id.cartonReciclado);
        dineroRecaudado=findViewById(R.id.dineroRecaudado);

        Intent pantallaPrin=new Intent(getApplicationContext(), HomeActivity.class);
        Intent pantallaAtras=new Intent(getApplicationContext(), HomeActivity.class);

        Intent receive= getIntent();
        String id= receive.getStringExtra("idUser");

        File papelFile= new File(getFilesDir(),"papel.txt");
        File plasticoFile= new File(getFilesDir(),"plastico.txt");
        File cartonFile= new File(getFilesDir(),"carton.txt");

        ArrayList<Papel> papelList= listPapel(papelFile,id);
        ArrayList<Plastico> plasticoList= listPlastico(plasticoFile,id);
        ArrayList<Carton> cartonList= listCarton(cartonFile,id);

        totalRecicladoPapel(papelList);
        totalRecicladoPlastico(plasticoList);
        totalRecicladoCarton(cartonList);

        int total=totalPayPapel(papelList)+totalPayPlastico(plasticoList)+totalPayCarton(cartonList);
        dineroRecaudado.setText("$ "+total);
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

    public void totalRecicladoPapel(ArrayList<Papel>list){
        int total=0;

        for (Papel i: list){
            total+=i.getQuantity();

        }
        totalPapel.setText(total+" Kg");

    }
    public void totalRecicladoPlastico(ArrayList<Plastico>list){
        int total=0;

        for (Plastico i: list){
            total+=i.getQuantity();

        }
        totalPlastico.setText(total+" Kg");

    }

    public void totalRecicladoCarton(ArrayList<Carton>list){
        int total=0;

        for (Carton i: list){
            total+=i.getQuantity();

        }
        totalCarton.setText(total+" Kg");

    }
    public ArrayList<Papel> listPapel(File papel,String user){
        ArrayList<Papel> list= new ArrayList<>();

        try {
            FileReader fileReader=new FileReader(papel);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String item;
            while ((item=bufferedReader.readLine())!=null){
                String [] data= item.split(",");
                int quantity= Integer.parseInt(data[0]);
                int price= Integer.parseInt(data[1]);
                String month= data[2];
                String userId= data[3];
                if (userId.equals(user)){
                    Papel papelObj= new Papel(quantity,price,month,userId);
                    list.add(papelObj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Plastico> listPlastico(File plastico,String user){
        ArrayList<Plastico> list= new ArrayList<>();

        try {
            FileReader fileReader=new FileReader(plastico);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String item;
            while ((item=bufferedReader.readLine())!=null){
                String [] data= item.split(",");
                int quantity= Integer.parseInt(data[0]);
                int price= Integer.parseInt(data[1]);
                String month= data[2];
                String userId= data[3];
                if (userId.equals(user)){
                    Plastico plasticObj= new Plastico(quantity,price,month,userId);
                    list.add(plasticObj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Carton> listCarton(File carton,String user){
        ArrayList<Carton> list= new ArrayList<>();

        try {
            FileReader fileReader=new FileReader(carton);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String item;
            while ((item=bufferedReader.readLine())!=null){
                String [] data= item.split(",");
                int quantity= Integer.parseInt(data[0]);
                int price= Integer.parseInt(data[1]);
                String month= data[2];
                String userId= data[3];
                if (userId.equals(user)){
                    Carton cartonObj= new Carton(quantity,price,month,userId);
                    list.add(cartonObj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public int totalPayPapel(ArrayList<Papel>list){

        int pay=0;
        for (Papel i: list){
            pay+=i.getPrice();
        }
        return pay;
    }

    public int totalPayPlastico(ArrayList<Plastico>list){

        int pay=0;
        for (Plastico i: list){
            pay+=i.getPrice();
        }
        return pay;
    }

    public int totalPayCarton(ArrayList<Carton>list){

        int pay=0;
        for (Carton i: list){
            pay+=i.getPrice();
        }
        return pay;
    }

}