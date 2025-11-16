package com.example.controlesbasicos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * La activity hay que declararla en el Manifest.xml
 */
public class ActivityMultiAutoCompleteTextView extends AppCompatActivity {
    // 1. Define el array de strings con las sugerencias
    private static final String[] LANGUAGES = new String[] {
            "Java", "Kotlin", "Python", "JavaScript", "C++", "C#", "Swift", "Go", "Ruby", "PHP", "Rust"
    };

    private MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiauto_completetextview);

        // 2. Obtiene la referencia del control del layout
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextViewId);

        // 3. Crea un ArrayAdapter para conectar las sugerencias con el control
        // Se usa un layout simple proporcionado por Android para mostrar cada sugerencia
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, LANGUAGES);

        // 4. Asigna el adaptador al MultiAutoCompleteTextView
        multiAutoCompleteTextView.setAdapter(adapter);

        // 5. Establece el tokenizador para separar las entradas con comas
        // Esto le dice al control que cada vez que se introduce una coma,
        // el texto anterior es un "chip" completado y debe empezar a sugerir de nuevo.
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
