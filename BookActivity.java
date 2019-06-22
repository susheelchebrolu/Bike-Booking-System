package com.example.hp.rideabike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }
    public void book(View view){
        Intent i=new Intent(this,CategoryActivity.class);
        startActivity(i);
    }
}
