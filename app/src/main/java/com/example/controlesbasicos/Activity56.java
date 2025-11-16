package com.example.controlesbasicos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity56 extends AppCompatActivity implements View.OnClickListener {

    ProgressBar p;
    Button b;
    TextView t;
    Handler h = new Handler();
    int i = 0;
    boolean isActivo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_6);

        p = findViewById(R.id.progressBar);
        b = findViewById(R.id.button);
        t = findViewById(R.id.porcentaje);

        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button && !isActivo) {
            isActivo = true;
            i = 0;
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (i <= 100) {
                        final int progresoActual = i;
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                t.setText(progresoActual + " %");
                                p.setProgress(progresoActual);

                                if (progresoActual == 100) {
                                    // Lanzamos la Activity de imagen
                                    Intent x = new Intent(Activity56.this, Imagen.class);
                                    startActivity(x);
                                    isActivo = false; // Ya terminó
                                }
                            }
                        });
                        i++;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            hilo.start();
        }
    }
}
