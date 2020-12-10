package com.samaaps.architecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etLogin;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(view -> {
            if (checkLogin(etLogin.getText().toString()) && checkPassword(etPassword.getText().toString())) {
                startActivity();
            } else {
                Toast.makeText(this,"Логин или пароль не правильный", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void startActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean checkLogin(String login) {
        for (int i = 0; i < Utils.logins.length; i++) {
            if (Utils.logins[i].equals(login)) return true;
        }
        return false;
    }

    private boolean checkPassword(String password) {
        return password.equals(Utils.password);
    }
}