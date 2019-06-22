package com.example.hp.rideabike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText e1=findViewById(R.id.name);
        EditText e2=findViewById(R.id.email);
        EditText e3=findViewById(R.id.mnumber);
        EditText e4=findViewById(R.id.Password);
        EditText e5=findViewById(R.id.reenterPassword);
    }
    public void save(View view) {
            Toast.makeText(this,"Details Saved Successfully!!",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }
    }
