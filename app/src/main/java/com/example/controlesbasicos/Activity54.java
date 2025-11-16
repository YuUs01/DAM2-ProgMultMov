package com.example.controlesbasicos;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Activity54 extends AppCompatActivity implements TextView.OnEditorActionListener, TextWatcher{
    private EditText correoEditText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_4);
        correoEditText = findViewById(R.id.editTextEmail);

        correoEditText.setOnEditorActionListener(this);
        correoEditText.addTextChangedListener(this);
    }

    public void afterTextChanged(Editable s) {
        // Se llama justo después de que el texto ha cambiado.
        if (s.length() > 0 && !s.toString().contains("@")) {
            correoEditText.setError("El correo no es válido");
        } else {
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}
