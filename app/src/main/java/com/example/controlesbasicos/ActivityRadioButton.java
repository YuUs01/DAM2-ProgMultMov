package com.example.controlesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Hay que declarar la Activity en el Manifest
 *
 * En la ActivityRadioButton.java, implementaremos la interfaz RadioGroup.OnCheckedChangeListener y su método correspondiente.
 *
 *     Implementar RadioGroup.OnCheckedChangeListener en la declaración de la clase.
 *
 *     En onCreate, obtener la referencia del RadioGroup y asignarle el listener (this).
 *
 *     Sobrescribir el método onCheckedChanged fuera de onCreate para manejar el cambio de selección en tiempo real.
 *
 *     Añadir un método para el botón que muestre la selección actual.
 */
public class ActivityRadioButton extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroupNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        // Obtenemos la referencia del RadioGroup del layout
        radioGroupNivel = findViewById(R.id.radioGroupNivel);

        // 2. Establecemos el listener para este RadioGroup.
        // Como la clase implementa la interfaz, pasamos 'this' como el listener.
        radioGroupNivel.setOnCheckedChangeListener(this);
    }

    /**
     * Este método es llamado automáticamente CADA VEZ que la selección en el RadioGroup cambia.
     * @param group El RadioGroup en el que la selección cambió.
     * @param checkedId El ID del RadioButton que ahora está seleccionado.
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // Encontramos el RadioButton que fue seleccionado usando su ID
        RadioButton radioButtonSeleccionado = findViewById(checkedId);

        // Mostramos un Toast con el texto del RadioButton seleccionado
        Toast.makeText(this, "Selección cambiada a: " + radioButtonSeleccionado.getText(),
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Este método es llamado cuando el botón "Confirmar" es pulsado, gracias al
     * atributo android:onClick="confirmarSeleccion" en el XML.
     * @param view La vista (Button) que fue pulsada.
     */
    public void confirmarSeleccion(View view) {
        // Obtenemos el ID del RadioButton seleccionado actualmente en el grupo
        int selectedId = radioGroupNivel.getCheckedRadioButtonId();

        // Verificamos si alguna opción ha sido seleccionada.
        // getCheckedRadioButtonId() devuelve -1 si no hay nada seleccionado.
        if (selectedId == -1) {
            Toast.makeText(this, "Por favor, selecciona un nivel de experiencia.",
                    Toast.LENGTH_LONG).show();
        } else {
            // Encontramos el RadioButton usando el ID que obtuvimos
            RadioButton radioButtonSeleccionado = findViewById(selectedId);
            String seleccion = radioButtonSeleccionado.getText().toString();

            // Mostramos un mensaje de confirmación
            Toast.makeText(this, "Nivel confirmado: " + seleccion, Toast.LENGTH_LONG).show();
        }
    }
}
