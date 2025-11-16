package com.example.controlesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Hay que declarar la Activity en el Manifest
 */
public class ActivityCheckBox extends AppCompatActivity {
    private CheckBox cbDeporte, cbLeer, cbProgramar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        // Obtenemos las referencias a los CheckBox para poder consultar su estado después
        cbDeporte = findViewById(R.id.checkbox_deporte);
        cbLeer = findViewById(R.id.checkbox_leer);
        cbProgramar = findViewById(R.id.checkbox_programar);
    }

    /**
     * Este método es llamado cuando CUALQUIER CheckBox es pulsado,
     * gracias al atributo android:onClick="onCheckboxClicked" en el XML.
     * @param view La vista (CheckBox) que fue pulsada.
     */
    public void onCheckboxClicked(View view) {
        // Hacemos un casting de la vista genérica a un CheckBox
        CheckBox checkBox = (CheckBox) view;
        boolean isChecked = checkBox.isChecked();

        // Usamos un if encadenados para determinar qué CheckBox fue pulsado
        // y reaccionar de manera individual a cada uno.
        if (view.getId() == R.id.checkbox_deporte) {
            if (isChecked) {
                Toast.makeText(this, "¡El deporte es vida!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Deporte desmarcado", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.checkbox_leer) {
            if (isChecked) {
                Toast.makeText(this, "Un buen libro te espera", Toast.LENGTH_SHORT).show();
            }
        } else if(view.getId() == R.id.checkbox_programar) {
            if (isChecked) {
                Toast.makeText(this, "¡A picar código!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Este método es llamado cuando el botón "Mostrar selección" es pulsado.
     * Recorre todos los CheckBox y construye un mensaje con los que están seleccionados.
     * @param view La vista (Button) que fue pulsada.
     */
    public void mostrarSeleccion(View view) {
        StringBuilder hobbies = new StringBuilder("Hobbies seleccionados:\n");
        int count = 0;

        if (cbDeporte.isChecked()) {
            hobbies.append("- Hacer deporte\n");
            count++;
        }
        if (cbLeer.isChecked()) {
            hobbies.append("- Leer libros\n");
            count++;
        }
        if (cbProgramar.isChecked()) {
            hobbies.append("- Programar\n");
            count++;
        }

        if (count == 0) {
            Toast.makeText(this, "No has seleccionado ningún hobby", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, hobbies.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
