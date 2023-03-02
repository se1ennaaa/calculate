package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double x;
    private Double y;
    private boolean isOperationClick;
    private String operation;
    private Double result;
    private Button cnopka;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        cnopka = findViewById(R.id.btn_next);
        cnopka.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            String Text = textView.getText().toString();
            intent.putExtra("key", Text);
            startActivity(intent);
        });
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clear:
                x = 0.0;
                y = 0.0;

                textView.setText("0");
                break;
            case R.id.btn_one:
               btnNumber(1);
                break;
            case R.id.btn_two:
              btnNumber(2);
                break;
            case R.id.btn_three:
                btnNumber(3);
                break;
            case R.id.btn_fo:
                btnNumber(4);
                break;
            case R.id.btn_five:
               btnNumber(5);
                break;
            case R.id.btn_six:
                btnNumber(6);
                break;
            case R.id.btn_seven:
                btnNumber(7);
                break;
            case R.id.btn_eith:
               btnNumber(8);

                break;
            case R.id.btn_nine:
               btnNumber(9);
                break;
            case R.id.btn_dot:
                textView.append(".");
                break;
            case R.id.btn_zero:
                btnNumber(0);
                break;


        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_equal:
                y = Double.valueOf(textView.getText().toString());
                cnopka.setVisibility(View.VISIBLE);
                if(operation == "+"){
                    result = x + y;
                }else if (operation == "-"){
                    result = x-y;
                }else if (operation == "*"){
                    result = x * y;
                }else if(operation == "/"){
                    result = x / y;
                }
                textView.setText(result.toString());
            break;

            case R.id.btn_minus:
                btnOperation("-");
                break;
            case R.id.btn_plus:
                btnOperation("+");
                break;
            case R.id.btn_multiplication:
                btnOperation("*");
                break;
            case R.id.division:
                btnOperation("/");
                break;

        }
        isOperationClick = true;

    }

    public void btnOperation(String operation){
        this.operation = operation;
        cnopka.setVisibility(View.INVISIBLE);
        x = Double.valueOf(textView.getText().toString());
    }
    public void btnNumber(Integer number){
        cnopka.setVisibility(View.INVISIBLE);
        if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(number.toString());
        } else {
            textView.append(number.toString());
        }
    }
}






