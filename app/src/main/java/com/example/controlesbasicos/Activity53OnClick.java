package com.example.controlesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Activity53OnClick extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_3_on_click);
    }

    public void onBotonPulsado (View view){
        TextView tvMensaje = findViewById(R.id.tvMensaje);

        tvMensaje.setText("BOTON PULSADO");
        tvMensaje.setTextColor(ContextCompat.getColor(Activity53OnClick.this, R.color.custom_green));
    }
}
