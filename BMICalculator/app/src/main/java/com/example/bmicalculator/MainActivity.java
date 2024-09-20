package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initControl();
    }

    EditText etHeight;
    EditText etWeight;
    Button btnTinh;
    EditText etBMI;
    EditText etChanDoan;

    private void initControl(){
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnTinh = findViewById(R.id.btnTinh);
        etBMI = findViewById(R.id.etBMI);
        etChanDoan = findViewById(R.id.etChanDoan);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((etWeight.getText().toString().isEmpty()||etHeight.getText().toString().isEmpty()))
                    return;
                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());

                float BMI = weight/(height*height);

                etBMI.setText(String.valueOf(BMI));
                etChanDoan.setText(chuanDoan(BMI));
            }
        });
    }

    private String chuanDoan(float BMI){
           if (BMI<18)
               return "người gầy";
           else if ( (BMI >= 18) && (BMI <= 24.9) ) {
               return "Người bình thường";
           } else if ((BMI >= 25) && (BMI <= 29.9)){
               return "Người béo phì độ I";
           } else if ((BMI >= 20) && (BMI <= 34.9)) {
               return "Người béo phì độ II";
           }else
               return "Người béo phì độ III";
    }
}