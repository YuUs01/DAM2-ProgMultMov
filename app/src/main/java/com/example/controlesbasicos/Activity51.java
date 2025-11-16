package com.example.controlesbasicos;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class Activity51 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Actividad 5.1.1 que consiste en mostrar el layout creado
       // setContentView(R.layout.activity_5_1);


        //Actividad 5.1.2
//        setContentView(R.layout.activity_5_1);
        //obtenemos la referencia al textView del contenido
//        TextView tvContenido = findViewById(R.id.tvContenido);

        //establecemos las propiedades desde java

//        tvContenido.setText("Texto construido desde Java. \nTamaño 20sp, Italic y color blue");
//        tvContenido.setTextSize(20);
//        tvContenido.setTypeface(null, Typeface.ITALIC);
//        tvContenido.setTextColor(ContextCompat.getColor(this, R.color.custom_blue));


        //Actividad 5.1.3

//        setContentView(R.layout.activity_5_1);
//        TextView tvContenido = findViewById(R.id.tvContenido);
//
//        tvContenido.append("\nTexto añadido con Append desde Java");
//        tvContenido.setTextColor(ContextCompat.getColor(this, R.color.custom_blue));

        //Activity 5.1.4

//        setContentView(R.layout.activity_5_1);
//        TextView tvContenido = findViewById(R.id.tvContenido);
//        Typeface typeface = ResourcesCompat.getFont(this, R.font.demo_coneriascript);
//        tvContenido.setTypeface(typeface);
    }
}
