package com.example.randomuicolor;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int colorID [] = {R.color.teal_200,R.color.teal_700,R.color.puple_200,R.color.puple_500,R.color.puple_700};
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
        final ConstraintLayout constraintLayout;
        constraintLayout = findViewById(R.id.main);
        constraintLayout.setBackgroundColor(getResources().getColor(colorID[new  Random().nextInt(colorID.length)]));
        Random rnd = new Random();
    }
}