package com.elmundobinario.adiciondetextviewsdinamicamente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numTextViewsEditText;
    public String[] textViewsArray;
    public int numDimamicTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numTextViewsEditText = (EditText) findViewById(R.id.numTextViewsEditText);

    }

    public void onclikEditText(View view) {
        // obtenemos el texto ingresado en el EditText para crear views dinaḿicas
        numDimamicTextViews = Integer.parseInt(numTextViewsEditText.getText().toString());
        // cada indice del array de este string será un button (view) creado dinámicamente
        textViewsArray = new String[numDimamicTextViews];
        // creamos el layout donde agregar los botones:
        LinearLayoutCompat linearLayout = (LinearLayoutCompat) findViewById(R.id.layout);
        for (int i = 0; i < numDimamicTextViews; i++) {
            textViewsArray[i] = String.valueOf(i);
            // creamos la view, en este caso un Button:
            Button boton = new Button(MainActivity.this);
            // establecemos los parámetros de diseño a la view:
            boton.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                            LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
            // y le ponemos un texto
            boton.setText(textViewsArray[i]);
            boton.setId(i);
            linearLayout.addView(boton);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Botón: " + v.getId(),
                            Toast.LENGTH_LONG)
                            .show();
                }
            });
        }
        // happy coding
    }
}
