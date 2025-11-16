package com.example.controlesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Hay que definir la Activity en el Manifest
 * Para que el código esté bien organizado, la lógica que gestiona
 * los cambios en la valoración se implementará a través de la interfaz
 * RatingBar.OnRatingBarChangeListener, con su método definido fuera del onCreate.
 */
public class ActivityRatinBar extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener{
    private RatingBar ratingBar;
    private TextView textViewRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        // Obtenemos las referencias de las vistas del layout
        ratingBar = findViewById(R.id.ratingBar);
        textViewRating = findViewById(R.id.textViewRating);

        // 2. Establecemos el listener para esta RatingBar.
        // Como la clase implementa la interfaz, pasamos 'this' como el listener.
        ratingBar.setOnRatingBarChangeListener(this);
    }

    /**
     * Este método es llamado automáticamente CADA VEZ que la valoración en la RatingBar cambia.
     * Se ejecuta en tiempo real a medida que el usuario cambia la calificación.
     * @param ratingBar La instancia de la RatingBar que cambió.
     * @param rating El nuevo valor de la calificación (float).
     * @param fromUser 'true' si el cambio fue iniciado por el usuario, 'false' si fue por código.
     */
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        // Actualizamos el TextView para mostrar el valor numérico actual
        textViewRating.setText("Valoración: " + rating + " / " + ratingBar.getNumStars());
    }

    /**
     * Este método es llamado cuando el botón "Enviar Valoración" es pulsado, gracias al
     * atributo android:onClick="enviarValoracion" en el XML.
     * @param view La vista (Button) que fue pulsada.
     */
    public void enviarValoracion(View view) {
        // Obtenemos la calificación actual directamente desde la RatingBar
        float calificacionActual = ratingBar.getRating();

        if(calificacionActual > 3.0) {
            // Mostramos un mensaje de confirmación al usuario
            Toast.makeText(this, "Su valoración de " + calificacionActual + " estrellas nos hace sentir muy orgullosos.",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Intentaremos mejorar. Gracias por tu valoración de " + calificacionActual + " estrellas.",
                    Toast.LENGTH_LONG).show();
        }
    }
}
