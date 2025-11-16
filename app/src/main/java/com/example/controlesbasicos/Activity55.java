package com.example.controlesbasicos;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Activity55 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroupNivel;
    private TextView tvResultado;
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_5);
        tvResultado = findViewById(R.id.tvResultado);
        // Obtenemos la referencia del RadioGroup del layout
        radioGroupNivel = findViewById(R.id.radioGroupDias);

        // 2. Establecemos el listener para este RadioGroup.
        // Como la clase implementa la interfaz, pasamos 'this' como el listener.
        radioGroupNivel.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
        RadioButton radioButtonSeleccionado = findViewById(checkedId);

        tvResultado.setText("Seleccionado: " + radioButtonSeleccionado.getText());
        Toast.makeText(this, "Seleccion cambiada a: " + radioButtonSeleccionado.getText(),
                Toast.LENGTH_SHORT).show();
    }
}
