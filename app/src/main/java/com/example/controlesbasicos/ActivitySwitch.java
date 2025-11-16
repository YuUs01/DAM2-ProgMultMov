package com.example.controlesbasicos;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Hay que declarar la Activity en el Manifest
 *
 * Tenemos que implementar los métodos de la interfaz CompoundButton.OnCheckedChangeListener
 * para escuchar los cambios de estado del Switch
 */
public class ActivitySwitch extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private Switch switchModoOscuro;
    private TextView textViewEstado;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        // Obtenemos las referencias de las vistas del layout
        switchModoOscuro = findViewById(R.id.switchModoOscuro);
        textViewEstado = findViewById(R.id.textViewEstado);
        mainLayout = findViewById(R.id.main_layout);

        // 2. Establecemos el listener para este Switch.
        // Como la clase implementa la interfaz, pasamos 'this' como el listener.
        switchModoOscuro.setOnCheckedChangeListener(this);
    }

    /**
     * Este método es llamado automáticamente CADA VEZ que el estado del Switch cambia.
     * @param buttonView El control que cambió su estado (nuestro Switch).
     * @param isChecked El nuevo estado del control. 'true' si está encendido (ON), 'false' si está apagado (OFF).
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // El Switch está en estado ON (encendido)
            textViewEstado.setText("El modo oscuro está activado");
            mainLayout.setBackgroundColor(Color.DKGRAY);
            textViewEstado.setTextColor(Color.WHITE);
        } else {
            // El Switch está en estado OFF (apagado)
            textViewEstado.setText("El modo oscuro está desactivado");
            mainLayout.setBackgroundColor(Color.WHITE);
            textViewEstado.setTextColor(Color.BLACK);
        }
    }
}
