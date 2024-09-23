package com.example.calculator3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import  org.mozilla.javascript.Context;
import  org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result_tv,solution_tv;
    Button buttonC, buttonBrackOpen,buttonBrackClose;
    Button buttonDivide,buttonMultiply,buttonPlus,buttonMinus,buttonEquals;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button buttonAC, buttonDot;
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

        result_tv = findViewById(R.id.Result_tv);
        solution_tv = findViewById(R.id.solution_tv);
        assginId(buttonC,R.id.buttonC);
        assginId(buttonBrackOpen,R.id.button_open_bracket);
        assginId(buttonBrackClose,R.id.button_close_bracket);
        assginId(buttonDivide,R.id.button_divide);
        assginId(buttonMultiply,R.id.button_multiply);
        assginId(buttonPlus,R.id.button_plus);
        assginId(buttonMinus,R.id.button_minus);
        assginId(buttonEquals,R.id.button_equal);
        assginId(button0,R.id.button0);
        assginId(button1,R.id.button1);
        assginId(button2,R.id.button2);
        assginId(button3,R.id.button3);
        assginId(button4,R.id.button4);
        assginId(button5,R.id.button5);
        assginId(button6,R.id.button6);
        assginId(button7,R.id.button7);
        assginId(button8,R.id.button8);
        assginId(button9,R.id.button9);
        assginId(buttonAC,R.id.button_ac);
        assginId(buttonDot,R.id.button_dot);
    }

    void assginId(Button btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solution_tv.getText().toString();

        if (buttonText.equals("AC")){
            solution_tv.setText("");
            result_tv.setText("0");
            return;
        }
        if (buttonText.equals("=")){
            solution_tv.setText(result_tv.getText().toString());
            return;
        }

        if (buttonText.equals("C")){
            if (dataToCalculate.isEmpty()){
                result_tv.setText("0");
                solution_tv.setText("");
                return;
            }
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length()-1);
        }else {
            dataToCalculate = dataToCalculate+buttonText;
        }

        solution_tv.setText(dataToCalculate);

        if (!dataToCalculate.isEmpty()){
            String finalResult = getResult(dataToCalculate);
            if (!finalResult.equals("Err")){
                result_tv.setText(finalResult);
            }
        }else{
            result_tv.setText("0");
            solution_tv.setText("");

        }


    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();

            // Kiểm tra và chuyển kết quả về kiểu số thực
            double numericResult = Double.parseDouble(finalResult);

            // Làm tròn kết quả đến 2 chữ số thập phân
            if (numericResult == (long) numericResult) {
                // Nếu là số nguyên, trả về kết quả dưới dạng số nguyên
                finalResult = String.format("%d", (long) numericResult);
            } else {
                // Nếu không phải số nguyên, làm tròn đến 2 chữ số thập phân (có thể tùy chỉnh)
                finalResult = String.valueOf(numericResult);
            }

            return finalResult;
        } catch (Exception e) {
            return "Err";
        } finally {
            Context.exit();
        }
    }

}