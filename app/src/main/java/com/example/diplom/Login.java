package com.example.diplom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    EditText memail, mpassword;
    Button login;
    TextView signUp;
    DBhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBhelper(this);
        memail = (EditText) findViewById(R.id.username);
        mpassword = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.btn_login);
        signUp = (TextView) findViewById(R.id.SignUp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString();
                String password = mpassword.getText().toString();
                Boolean Chkemailpass = db.emailPassword(email, password);
                if (Chkemailpass == true) {
                    startActivity(new Intent(getApplicationContext(), Quiz.class));

                    Toast.makeText(getApplicationContext(), "Амжилттай нэвтэрлээ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Нэвтрэх өгөгдөл буруу байна", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }
}
