package com.example.controlesbasicos;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

/**
 * Hay que declarar la Activity en el AndroidManifest.xml
 */

/**
 * Implementar AdapterView.OnItemSelectedListener en la declaración de la clase.
 *
 * Configurar el Spinner y su adaptador dentro del método onCreate.
 *
 * Asignar el listener de selección al Spinner.
 *
 * Sobrescribir los métodos onItemSelected y onNothingSelected fuera
 * del onCreate para manejar los eventos de selección.
 */
public class ActivitySpinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerPlanetas;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // Referenciamos las vistas del layout
        spinnerPlanetas = findViewById(R.id.spinnerPlanetas);
        textViewResultado = findViewById(R.id.textViewResultado);

        // 2. Creamos un ArrayAdapter usando un array de strings y un layout por defecto para el spinner
        // El array de strings puede definirse en R.array (recomendado) o directamente en el código.
        /**
         * Recurso Adicional: Array de Strings
         * Para que el código funcione, necesitas definir el array de planetas en el
         * archivo de recursos res/values/strings.xml.
         */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        // 3. Especificamos el layout a usar cuando la lista de opciones aparece
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 4. Aplicamos el adaptador al spinner
        spinnerPlanetas.setAdapter(adapter);

        // 5. Establecemos el listener para este Spinner.
        // Como la clase implementa la interfaz, pasamos 'this' como el listener.
        spinnerPlanetas.setOnItemSelectedListener(this);
    }

    // --- Métodos de la interfaz AdapterView.OnItemSelectedListener ---

    /**
     * Este método se invoca cuando un ítem del Spinner ha sido seleccionado.
     * @param parent El AdapterView donde la selección ocurrió (nuestro Spinner).
     * @param view La vista dentro del AdapterView que fue pulsada.
     * @param position La posición del ítem seleccionado en el adaptador.
     * @param id El ID de la fila del ítem que fue seleccionado.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Obtenemos el ítem seleccionado usando la posición
        String planetaSeleccionado = parent.getItemAtPosition(position).toString();

        // Actualizamos el TextView con la selección
        Typeface typeface = ResourcesCompat.getFont(this, R.font.demo_coneriascript);
        textViewResultado.setTypeface(typeface, Typeface.BOLD_ITALIC);
        textViewResultado.setTextColor(Color.BLUE);
        textViewResultado.setTextSize(24);
        textViewResultado.setText("Planeta seleccionado: " + planetaSeleccionado);

        // Opcional: Mostramos un Toast para notificar al usuario
        // Evitamos mostrar el Toast para la selección inicial (posición 0) si no es interactiva
        if (position > 0) {
            Toast.makeText(parent.getContext(), "Has seleccionado: " + planetaSeleccionado, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este método se invoca cuando la selección del Spinner desaparece.
     * Esto puede ocurrir, por ejemplo, si el adaptador se vacía mientras el Spinner está abierto.
     * Generalmente, no es necesario implementar una lógica compleja aquí.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Opcional: Código a ejecutar cuando no hay nada seleccionado
        textViewResultado.setText("Planeta seleccionado: Ninguno");
    }
}
