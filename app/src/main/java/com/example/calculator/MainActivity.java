package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn00, btnplus, btnminus, btnmulti, btndivide, btnpercent, btnequals, btnc, btnback, btndot;
    TextView tv;
    String op1, op2, oprt;
    int k = 0;
    int l = 0;  //for backspace code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        btn00 = findViewById(R.id.btn_00);
        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        btnmulti = findViewById(R.id.btnmulti);
        btndivide = findViewById(R.id.btndivide);
        btnpercent = findViewById(R.id.btnpercent);
        btnequals = findViewById(R.id.btnequals);
        btnc = findViewById(R.id.btnC);
        btnback = findViewById(R.id.btnback);
        btndot = findViewById(R.id.btndot);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn00.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnmulti.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btnpercent.setOnClickListener(this);
        btnequals.setOnClickListener(this);
        btnc.setOnClickListener(this);
        btnback.setOnClickListener(this);
        btndot.setOnClickListener(this);

    }

    void calc() {
        float x, y, z;
        x = Float.parseFloat(op1);
        y = Float.parseFloat(op2);

        if (oprt.equals("+")) {
            z = x + y;
        } else if (oprt.equals("-")) {
            z = x - y;
        } else if (oprt.equals("*")) {
            z = x * y;
        } else if (oprt.equals("%")) {
            z = x % y;
        } else {
            z = x / y;
        }
        tv.setText("" + z);

    }

    @Override
    public void onClick(View view) {

        Button b = (Button) view;

        if (b == btn0 || b == btn1 || b == btn2 || b == btn3 || b == btn4 || b == btn5 || b == btn6 || b == btn7 || b == btn8 || b == btn9 || b == btndot || b == btn00) {

            if (k == 0) {
                tv.setText(b.getText().toString());
                k = 1;
            } else {
                tv.setText(tv.getText().toString() + b.getText().toString());

            }

        }

        if (b == btnplus || b == btnminus || b == btnmulti || b == btndivide || b == btnpercent) {
            op1 = tv.getText().toString();
            oprt = b.getText().toString();
            k = 0;
        }
        if (b == btnequals) {
            op2 = tv.getText().toString();
            calc();
            l=1;

        }
        if (b == btnc) {
            tv.setText("0");
        }
        if (b == btnback) {
            String str = tv.getText().toString();
            if (l == 0) {
                if (str.length() >= 1) {
                    str = str.substring(0, str.length() - 1);
                    tv.setText(str);
                } else {
                    tv.setText("0");
                    k = 0;
                }

            }
            else
            {
                Toast.makeText(this, "Cannot Edit Answer", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
