package com.example.controlesbasicos;

import static com.example.controlesbasicos.R.color.miColorRed;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.content.res.ResourcesCompat;
import android.graphics.Typeface;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Hay que definir la Activity en el Manifest
 *
 * En ActivityButton.java implementamos la interfaz OnClickListener y OnCheckedChangeListener
 * para desarrollar la lógica de los botones
 */
public class ActivityButton extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button miBotonJava = findViewById(R.id.miBoton);
        miBotonJava.setOnClickListener(this);

        Button miBotonJava1 = findViewById(R.id.miBoton_1);
        miBotonJava1.setOnClickListener(this);

        ToggleButton toggleButton = findViewById(R.id.miToggle);
        toggleButton.setOnCheckedChangeListener(this);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);

        /**
         * Sino implementamos la interfaz, podemos desarrollar la lógica
         * de los botones a través del método setOnClickListener.
         * Pero es más profesional y el código queda más estructurado
         * implementando los métodos de la interfaz
         */
//        miBotonJava.setOnClickListener(view -> {
//            // Código que se ejecutará
//            TextView miTexto= (TextView)findViewById(R.id.texto);
//            Typeface typeface = ResourcesCompat.getFont(this, R.font.milky_candy);
//            miTexto.setTypeface(typeface);
//            miTexto.setText("Estoy programando");
//            miTexto.setTextColor(Color.RED);
//        });

    }


    @Override
    public void onClick(View v) {
        int id = v.getId(); // Obtenemos el ID una vez

        if (id == R.id.miBoton) {
            // Código que se ejecutará
            TextView miTexto= (TextView)findViewById(R.id.texto);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.milky_candy);
            miTexto.setTypeface(typeface);
            miTexto.setText("Estoy programando");
            miTexto.setTextColor(Color.RED);
        } else if(id == R.id.miBoton_1) {
            TextView miTexto = (TextView) findViewById(R.id.texto);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.demo_coneriascript);
            miTexto.setTypeface(typeface);
            miTexto.setText("Pepe come salchichas");
            miTexto.setTextColor(getResources().getColor(miColorRed));
            miTexto.append("\n También le gusta el chorizo");

            // Animaciones miTExto1 definidas en xml
            Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
            miAnimacion.setRepeatMode(Animation.RESTART);
            miAnimacion.setRepeatCount(20);
            miTexto.startAnimation(miAnimacion);
        } else if(id == R.id.imageButton) {
            TextView miTexto = findViewById(R.id.texto);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.demo_coneriascript);
            miTexto.setTypeface(typeface, Typeface.BOLD_ITALIC);
            miTexto.setText("Donald Trump está como un cencerro");
            miTexto.setTextColor(Color.BLUE);
            miTexto.setTextSize(24);
        } else {
            // Código por defecto
        }
    }


    @Override
    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
        // El método onCheckedChanged se llama cada vez que el estado del botón cambia
        if (isChecked) {
            // El ToggleButton está activado
            Toast.makeText(getApplicationContext(), "El botón está Activado", Toast.LENGTH_SHORT).show();
            TextView miTexto = findViewById(R.id.texto);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.demo_coneriascript);
            miTexto.setTypeface(typeface);
            miTexto.setText("Maria juega al mus muy bien");
            miTexto.setTextColor(Color.BLUE);
        } else {
            // El ToggleButton está desactivado
            Toast.makeText(getApplicationContext(), "El botón está Desactivado", Toast.LENGTH_SHORT).show();
            TextView miTexto = findViewById(R.id.texto);
            miTexto.setTypeface(Typeface.DEFAULT);
            miTexto.setTextColor(Color.BLACK);
            miTexto.setText("Hello World!");
            miTexto.setTextSize(12);
        }
    }
}
