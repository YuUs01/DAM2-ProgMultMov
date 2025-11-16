package com.example.controlesbasicos;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity52 extends AppCompatActivity {

    private TextView textoAnimado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_2);

        textoAnimado = findViewById(R.id.texto_animado);

        // Cargar la animación que ya tienes (res/anim/tu_animacion.xml)
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion);

        // Aplicar la animación al TextView
        textoAnimado.startAnimation(animacion);
    }
}
