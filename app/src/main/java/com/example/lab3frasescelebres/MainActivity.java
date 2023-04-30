package com.example.lab3frasescelebres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button frase;
    Button generar;
    int numAleatorio = 0;
    String numAzar = "";
    private TextView numeroAzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generar = findViewById(R.id.generar_numero);
        frase = findViewById(R.id.mostrar_frase);

        numeroAzar = (TextView) findViewById(R.id.numero_aleatorio);

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numAleatorio = ((int) (Math.random() * 3 + 1));
                numAzar = String.valueOf(numAleatorio);
                numeroAzar.setText(numAzar);
            }
        });

        frase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numAleatorio == 1 || numAleatorio == 2 || numAleatorio == 3) {
                    abrirFraseActivity();
                }else {
                    displayToast(getString(R.string.action_number_zero));
                }
            }
        });
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void abrirFraseActivity(){
        Intent intent = new Intent(MainActivity.this, FraseActivity.class);
        intent.putExtra("azar", numAzar);
        startActivity(intent);
    }


}