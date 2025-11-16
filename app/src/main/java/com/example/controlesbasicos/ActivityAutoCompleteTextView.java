package com.example.controlesbasicos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAutoCompleteTextView extends AppCompatActivity {
    // 1. Definimos el array de Strings con las sugerencias
    private static final String[] LENGUAJES = new String[]{
            "Java", "JavaScript", "Python", "Kotlin", "Swift",
            "C++", "C#", "Ruby", "PHP", "Go", "TypeScript",
            "Scala", "Perl"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete_textview);

        // 2. Obtenemos la referencia al AutoCompleteTextView del layout
        AutoCompleteTextView textView = findViewById(R.id.miTexto);

        // 3. Creamos un ArrayAdapter
        // El ArrayAdapter se encargará de vincular nuestro array de Strings con el AutoCompleteTextView.
        // - El primer parámetro es el contexto (this).
        // - El segundo es un layout predefinido de Android para mostrar un elemento simple en la lista.
        // - El tercero es nuestro array de datos (las sugerencias).
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, LENGUAJES);

        // 4. Asignamos el adaptador al AutoCompleteTextView
        // A partir de este momento, el control ya sabe qué sugerencias mostrar.
        textView.setAdapter(adapter);
    }
}
