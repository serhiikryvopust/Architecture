package com.samaaps.architecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etLogin;
    EditText etPassword;
    ArrayList<UserModel> users;
    HashMap<Integer,UserModel> userTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);

        users = new Utils().getUsers();

        btnLogin.setOnClickListener(view -> {
            if (checkLogin(etLogin.getText().toString(),etPassword.getText().toString())) {
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

    private boolean checkLogin(String login, String password) {
        for (UserModel userModel : users ){
            if (userModel.getLogin().equals(login) && userModel.getPassword().equals(password)) return true;
        }
        return false;
    }
}