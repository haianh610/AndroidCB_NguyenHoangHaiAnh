package com.haianh610.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

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
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    EditText etSo1,etSo2;
    TextView txtKetQua;
    Button btnCong,btnTru,btnNhan,btnChia,btnChiaDu;

    private boolean checkET(){
        if (etSo1.getText().toString().isEmpty() || etSo2.getText().toString().isEmpty()){
            Toast.makeText(this, "Chưa nhập số !", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return false;
    }

    private void initControl() {
        etSo1 = findViewById(R.id.etSo1);
        etSo2 = findViewById(R.id.etSo2);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnCong = findViewById(R.id.btnClick);

        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnCHia);
        btnChiaDu = findViewById(R.id.btnChiaDu);


        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkET()) {
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    int ketQua = x + y;
                    txtKetQua.setText(String.valueOf(ketQua));
                } else {
                    ;
                }
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkET()) {
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    int ketQua = x - y;
                    txtKetQua.setText(String.valueOf(ketQua));
                } else {
                    ;
                }
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkET()) {
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    int ketQua = x - y;
                    txtKetQua.setText(String.valueOf(ketQua));
                } else {
                    ;
                }
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkET()) {
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    int ketQua = x / y;
                    txtKetQua.setText(String.valueOf(ketQua));
                } else {
                    ;
                }
            }
        });

        btnChiaDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkET()) {
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    int ketQua = x % y;
                    txtKetQua.setText(String.valueOf(ketQua));
                } else {
                    ;
                }
            }
        });
    }
}