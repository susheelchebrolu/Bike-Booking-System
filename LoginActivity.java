package com.example.hp.rideabike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText u,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        u=findViewById(R.id.mobile);
        p=findViewById(R.id.password);
    }
    public void login(View view) {
        if (u.getText().toString().trim().length() == 0 || p.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Please Enter All Credentials!!", Toast.LENGTH_LONG).show();
        }
        else if (u.getText().toString().equals("123456789") && p.getText().toString().equals("123456789")) {
            Toast.makeText(this, "Sucessfully LoggedIn!!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, BookActivity.class);
            startActivity(i);
        }
          else {
            Toast t= Toast.makeText(this,"Incorrect Credentials!!",Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
        resetAll(view);
    }
    public void signup(View view){
        Intent i=new Intent(this,RegisterActivity.class);
        startActivity(i);
        resetAll(view);
    }
    public void resetAll(View view){
        u.setText("");
        p.setText("");
    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
