package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OfferRide extends AppCompatActivity {

    private String getName, getEmail, getCarModel, getCarColor, getPlateLicense;
    private int getAge, getPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride);
    }

    public void makeDriverRegister(View view){
        Intent intent = new Intent(this, OfferRide2.class);

        //PEGAR OS DADOS FORNECIDOS E JOGAR NO BANCO DE DADOS




        startActivity(intent);
    }
}
