package com.example.controlesbasicos;

import static com.example.controlesbasicos.R.color.miColorRed;

import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.content.res.ResourcesCompat;
import android.graphics.Typeface;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivityText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView miTexto= (TextView)findViewById(R.id.texto);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.milky_candy);
        miTexto.setTypeface(typeface);
        miTexto.setText("Estoy programando");
        miTexto.setTextColor(Color.RED);

        TextView miTexto1= (TextView)findViewById(R.id.texto_1);
        Typeface typeface1 = ResourcesCompat.getFont(this, R.font.demo_coneriascript);
        miTexto1.setTypeface(typeface1);
        miTexto1.setText("Pepe come salchichas");
        miTexto1.setTextColor(getResources().getColor(miColorRed));
        miTexto1.append("\n También le gusta el chorizo");

        // Animaciones miTExto1 definidas en xml
        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        miTexto1.startAnimation(miAnimacion);

        // Animaciones miTexto definidas en Java
        AnimationSet animacion = new AnimationSet(true);
        AlphaAnimation aparicion = new AlphaAnimation(0,1);
        aparicion.setDuration(3000);
        animacion.addAnimation(aparicion);
        animacion.setRepeatMode(Animation.RESTART);
        animacion.setRepeatCount(20);
        miTexto.startAnimation(animacion);

    }
}