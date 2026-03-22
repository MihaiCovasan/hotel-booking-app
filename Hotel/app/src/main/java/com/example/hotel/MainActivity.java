package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.internal.ViewUtils;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister,btnLogin;
    EditText edtEmail;
    EditText edtPassword;
    public static String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();
                String url = "http://192.168.8.29/loginHotel.php";
                String type = "loginHotel";
                BackgroundLogin backgroundLogin = new BackgroundLogin(MainActivity.this);
                backgroundLogin .execute(url,type,email,password);

            }
        });

    }
}