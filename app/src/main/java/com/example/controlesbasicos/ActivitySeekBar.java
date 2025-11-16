package com.example.controlesbasicos;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Hay que declarar la Activity en el Manifest
 *
 * Para seguir las buenas prácticas y mantener el código organizado,
 * la lógica para gestionar los eventos del SeekBar se implementará a
 * través de la interfaz SeekBar.OnSeekBarChangeListener,
 * con sus métodos definidos fuera del onCreate.
 */
public class ActivitySeekBar extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private SeekBar seekBarVolumen;
    private TextView textViewValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        // Obtenemos las referencias de las vistas del layout
        seekBarVolumen = findViewById(R.id.seekBarVolumen);
        textViewValor = findViewById(R.id.textViewValor);

        // 2. Establecemos el listener para este SeekBar.
        // Como la clase implementa la interfaz, pasamos 'this' como el listener.
        seekBarVolumen.setOnSeekBarChangeListener(this);
    }

    // --- Métodos de la interfaz SeekBar.OnSeekBarChangeListener ---

    /**
     * Este método es llamado continuamente mientras el usuario arrastra el control deslizante.
     * Es ideal para dar feedback visual instantáneo, como actualizar un TextView con el valor numérico.
     * El parámetro fromUser es útil para distinguir si el cambio lo hizo el usuario o tu propio código
     * (por ejemplo, al restaurar un estado).
     * @param seekBar La instancia del SeekBar que está cambiando.
     * @param progress El valor actual del progreso (entre 0 y el máximo definido).
     * @param fromUser 'true' si el cambio fue iniciado por el usuario, 'false' si fue por código.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // Actualizamos el TextView para mostrar el valor actual en tiempo real
        textViewValor.setText("Volumen: " + progress);
    }

    /**
     * Este método es llamado cuando el usuario toca el control deslizante por primera vez
     * para empezar a arrastrarlo.
     * @param seekBar La instancia del SeekBar.
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Opcional: Puedes usarlo para dar una respuesta visual, como un Toast.
        Toast.makeText(this, "Ajustando volumen...", Toast.LENGTH_SHORT).show();
    }

    /**
     * Este método es llamado cuando el usuario suelta el control deslizante después de arrastrarlo.
     * @param seekBar La instancia del SeekBar.
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Opcional: Útil para realizar una acción final una vez que el valor ha sido seleccionado.
        Toast.makeText(this, "Volumen fijado en: " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
    }
}
