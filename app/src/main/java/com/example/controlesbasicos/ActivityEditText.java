package com.example.controlesbasicos;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// 1. La Activity implementa las interfaces de los listeners
// TextWatcher: Para reaccionar a los cambios en el texto mientras el usuario escribe.
// TextView.OnEditorActionListener: Para capturar la acción del teclado, como cuando el usuario presiona el botón de "Buscar".
// Esto es clave, ya que en el XML tenemos android:imeOptions="actionSearch".
public class ActivityEditText extends AppCompatActivity implements TextView.OnEditorActionListener, TextWatcher {

    // 2. Declara el EditText como una variable miembro de la clase
    private EditText correoEditText;
    private static final String TAG = "ActivityEditText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Asegúrate de que este layout contiene tu EditText
        setContentView(R.layout.activity_edit_text);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // 3. Inicializa el EditText en onCreate
        correoEditText = findViewById(R.id.correo);

        // 4. Asigna 'this' (la Activity) como el listener para los eventos
        correoEditText.setOnEditorActionListener(this);
        correoEditText.addTextChangedListener(this);
    }
    // 5. La lógica para la acción del teclado está FUERA de onCreate
//    ## ¿Por Qué Hacerlo de Esta Manera? 👍
//
//    Organización y Legibilidad: Tu método onCreate se mantiene limpio y se enfoca en su propósito principal:
//     inicializar la UI. La lógica de los eventos está encapsulada en sus propios métodos,
//     con nombres descriptivos.
// Mantenibilidad: Si necesitas cambiar cómo funciona un listener, sabes exactamente a qué método ir.
//  No tienes que buscar entre todo el código de onCreate.
//
//    Reutilización de Lógica: Si tuvieras varios EditText que deben realizar la misma acción,
//    podrías manejarlo desde el mismo método onEditorAction,
//     diferenciando cuál lo llamó a través de su ID (v.getId()).

    // --- Métodos del listener TextWatcher ---

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // No es necesario implementar nada aquí para este ejemplo
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // Se llama mientras el texto está cambiando
        Log.i(TAG, "El texto está cambiando: " + s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        // Se llama justo después de que el texto ha cambiado.
        // Útil para validaciones.
        if (s.length() > 0 && !s.toString().contains("@")) {
            correoEditText.setError("El correo no es válido");
        } else {
            correoEditText.setError(null); // Limpiar el error
        }
        TextView miTexto= (TextView)findViewById(R.id.texto);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.milky_candy);
        miTexto.setTypeface(typeface);
        miTexto.setText(s.toString());
        miTexto.setTextColor(Color.BLUE);
        miTexto.setTextSize(24);
    }

    // Método del listener: TextView.OnEditorActionListener
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // Comprobamos si la acción es la de "Buscar" definida en el XML
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // Aquí ejecutas la lógica de búsqueda
            String textoIntroducido = v.getText().toString();
            Toast.makeText(this, "Buscando: " + textoIntroducido, Toast.LENGTH_SHORT).show();

            // Ocultar el teclado (opcional)
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            return true; // Devuelve true para indicar que has manejado el evento
        }
        return false; // Devuelve false para que el sistema maneje el evento de otra forma
    }
}
