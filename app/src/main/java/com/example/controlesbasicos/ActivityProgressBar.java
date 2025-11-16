package com.example.controlesbasicos;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Hay que definir la Activity en el Manifest
 *
 * En ActivityProgressBar.java, implementaremos la lógica para mostrar/ocultar la barra circular
 * y para actualizar el progreso de la barra lineal. Usaremos un Handler para simular tareas
 * que toman tiempo sin bloquear el hilo principal de la UI.
 */
public class ActivityProgressBar extends AppCompatActivity {
    private ProgressBar progressBarCircular;
    private ProgressBar progressBarLineal;
    private Button btnIniciarCarga;
    private Button btnIniciarTarea;
    private TextView textViewProgreso;

    // Handler para gestionar tareas en segundo plano simuladas
    private Handler handler = new Handler();
    private int progreso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        // Obtenemos las referencias de las vistas
        progressBarCircular = findViewById(R.id.progressBarCircular);
        progressBarLineal = findViewById(R.id.progressBarLineal);
        btnIniciarCarga = findViewById(R.id.buttonIniciarCarga);
        btnIniciarTarea = findViewById(R.id.buttonIniciarTarea);
        textViewProgreso = findViewById(R.id.textViewProgreso);
    }

    /**
     * Este método es llamado por el botón "Simular Carga" gracias al android:onClick.
     * Muestra la barra circular durante 3 segundos y luego la oculta.
     *
     * ProgressBar Circular (Indeterminada):
     *
     *     Su control se basa en la visibilidad.
     *     Se muestra (View.VISIBLE) al empezar una tarea y se oculta (View.GONE) al terminar.
     *
     *     En el ejemplo, handler.postDelayed simula una operación de red o un cálculo que tarda 3 segundos.
     *     Es una forma sencilla de ejecutar un código después de un cierto tiempo sin bloquear la UI.
     * @param view La vista (Botón) que fue pulsada.
     */
    public void iniciarCarga(View view) {
        btnIniciarCarga.setEnabled(false);
        progressBarCircular.setVisibility(View.VISIBLE);

        // Usamos un Handler para simular una tarea que dura 3 segundos
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBarCircular.setVisibility(View.GONE);
                btnIniciarCarga.setEnabled(true);
            }
        }, 3000); // 3000 milisegundos = 3 segundos
    }

    /**
     * Este método es llamado por el botón "Iniciar Tarea" gracias al android:onClick.
     * Inicia un proceso que actualiza la barra lineal de 0 a 100.
     *
     * ProgressBar Lineal (Determinada):
     *
     *     Su control se basa en actualizar su valor con el método setProgress(int).
     *
     *     Para simular un progreso gradual, creamos un Runnable que se
     *     auto-ejecuta cada 50 milisegundos gracias a handler.postDelayed(this, ...).
     *     En cada ejecución, incrementa el progreso en 1 y actualiza tanto la barra como el TextView.
     *
     *     Este patrón de Handler y Runnable es fundamental en Android para
     *     realizar actualizaciones periódicas en la interfaz de usuario de forma segura.
     * @param view La vista (Botón) que fue pulsada.
     */
    public void iniciarTarea(View view) {
        btnIniciarTarea.setEnabled(false);
        progreso = 0;

        // Creamos un Runnable para actualizar el progreso
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (progreso <= 100) {
                    progressBarLineal.setProgress(progreso);
                    textViewProgreso.setText("Tarea programada: " + progreso + "%");
                    progreso++;
                    // Volvemos a ejecutar este mismo Runnable después de 50ms
                    handler.postDelayed(this, 50);
                } else {
                    // La tarea ha terminado
                    btnIniciarTarea.setEnabled(true);
                    textViewProgreso.setText("Tarea completada!");
                }
            }
        };

        // Iniciamos la ejecución del Runnable
        handler.post(runnable);
    }
}
