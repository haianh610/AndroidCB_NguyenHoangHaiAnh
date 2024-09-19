package com.example.c_fexchange;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    Button btnToC;
    Button btnToF;
    Button btnClear;
    EditText etFahrenheit;
    EditText etCelsius;

    private void initControl(){
        etCelsius = findViewById(R.id.etCelsius);
        etFahrenheit = findViewById(R.id.etFahrenheit);
        btnToC = findViewById(R.id.btnToC);
        btnToF = findViewById(R.id.btnToF);
        btnClear = findViewById(R.id.btnClear);

        btnToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etFahrenheit.getText().toString().isEmpty())
                    return;
                int F = Integer.parseInt(String.valueOf(etFahrenheit.getText()));
                int C  = ((F-32)*5)/9;
                etCelsius.setText(String.valueOf(C));
            }
        });

        btnToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etCelsius.getText().toString().isEmpty())
                    return;
                int C = Integer.parseInt(etCelsius.getText().toString());
                int F = ((C*9)/5)+32;
                etFahrenheit.setText(String.valueOf(F));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etFahrenheit.setText("");
                etCelsius.setText("");
            }
        });
    }
}