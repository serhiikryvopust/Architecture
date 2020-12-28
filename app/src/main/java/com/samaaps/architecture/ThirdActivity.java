package com.samaaps.architecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class ThirdActivity extends AppCompatActivity {
    private EditText etPhone;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnStar, btnDiez, btnCall, btnDel;
    private ArrayList<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        etPhone = findViewById(R.id.etPhone);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDel = findViewById(R.id.btnDel);
        btnStar = findViewById(R.id.btnStar);
        btnDiez = findViewById(R.id.btnDiez);
        btnCall = findViewById(R.id.btnCall);

        buttons = new ArrayList<>(Arrays.asList(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnStar, btnDiez));

        setClickListeners();

        btnCall.setOnClickListener(v -> call(etPhone.getText().toString()));

        btnDel.setOnClickListener(v -> {
            if (etPhone.getText().length() == 0) return;
            etPhone.setText(etPhone.getText().toString().substring(0, etPhone.getText().length() - 1));
        });
    }

    private void setClickListeners() {
        for (Button button : buttons) {
            button.setOnClickListener(v -> etPhone.setText(etPhone.getText().append(button.getText().toString())));
        }
    }

    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        startActivity(intent);
    }
}