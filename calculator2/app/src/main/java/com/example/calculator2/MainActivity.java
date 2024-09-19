package com.example.calculator2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    EditText etSo1;
    EditText etSo2;
    Button btnTong;
    Button btnTru;
    Button btnNhan;
    Button btnChia;
    Button btnUCLN;
    TextView txtKetQua;
    Button btnThoat;

    private boolean checkET(){
        if (etSo1.getText().toString().isEmpty() || etSo2.getText().toString().isEmpty()){
            Toast.makeText(this, "Chưa nhập số !", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return false;
    }

    void divBy0(){
        Toast.makeText(this,"div 0!",Toast.LENGTH_SHORT).show();
    }
    private void  initControl(){
        etSo1 = findViewById(R.id.etSo1);
        etSo2 = findViewById(R.id.etSo2);
        btnTong = findViewById(R.id.btnTong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnUCLN = findViewById(R.id.btnUCLN);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnThoat = findViewById(R.id.btnThoat);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkET()) {
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    int ketQua = x + y;
                    txtKetQua.setText(String.valueOf(ketQua));
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
                }
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkET()) {
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    int ketQua = x * y;
                    txtKetQua.setText(String.valueOf(ketQua));
                }
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkET()) {
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    if (y!=0){
                        int ketQua = x / y;
                        txtKetQua.setText(String.valueOf(ketQua));
                    }
                    else divBy0();
                }
            }
        });
        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkET()){
                    int x = Integer.parseInt(String.valueOf(etSo1.getText()));
                    int y = Integer.parseInt(etSo2.getText().toString());
                    int ketQua = findGCD(x,y);
                    txtKetQua.setText(String.valueOf(ketQua));
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private static int findGCD(int x, int y) {
        //base case
        if(y== 0){
            return x;
        }
        return findGCD(y, x%y);
    }
}