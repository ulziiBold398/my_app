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


public class Register extends AppCompatActivity {
    EditText email, mphone, mpassword;
    Button register;
    TextView mLoginBTN;
    DBhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DBhelper(this);
        email = (EditText) findViewById(R.id.username);
        mphone = (EditText) findViewById(R.id.phone);
        mpassword = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.btn_register);
        mLoginBTN = (TextView) findViewById(R.id.BTNLogin);

        mLoginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = email.getText().toString();
                String s2 = mpassword.getText().toString();
                String s3 = mphone.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Хоосон мэдээлэл оруулсн байна", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean chkemail = db.chkemail(s1);
                        if (chkemail == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Амжилттай бүтргэгдлээ", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email Бүртгэгдсэн байна", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Нууц үг таарсангүй", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }

}
