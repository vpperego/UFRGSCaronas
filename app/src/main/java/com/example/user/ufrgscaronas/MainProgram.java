package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainProgram extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToOfferARide(View view){
        Intent intent = new Intent(this, OfferRide.class);
        startActivity(intent);
    }

    public void goToSearchRide(View view){
        Intent intent = new Intent(this, SearchRide.class);
        startActivity(intent);
    }


}
