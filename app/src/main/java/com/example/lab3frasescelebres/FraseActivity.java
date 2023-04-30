package com.example.lab3frasescelebres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FraseActivity extends AppCompatActivity {

    Button regresar;
    private ImageView imagen;
    private TextView autor;
    private TextView frase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase);

        imagen = findViewById(R.id.autor_frase);
        autor = findViewById(R.id.nombre_autor);
        frase = findViewById(R.id.frase_autor);
        regresar = findViewById(R.id.boton_regresar);

        Intent intent = getIntent();
        String numAleatorioRecibido = getIntent().getExtras().getString("azar");

        switch (numAleatorioRecibido) {
            case "1":
                imagen.setImageResource(R.drawable.benedetti);
                autor.setText(R.string.benedetti);
                frase.setText(R.string.fraseBenedetti);
                break;
            case "2":
                imagen.setImageResource(R.drawable.camus);
                autor.setText(R.string.camus);
                frase.setText(R.string.fraseCamus);
                break;
            case "3":
                imagen.setImageResource(R.drawable.hitchcoock);
                autor.setText(R.string.hitchcok);
                frase.setText(R.string.fraseHitchcock);
                break;
        }

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
