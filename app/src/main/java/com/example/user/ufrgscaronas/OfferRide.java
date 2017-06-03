package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OfferRide extends AppCompatActivity {

    private String getDriverName, getDriverEmail, getDriverCarModel, getDriverCarColor, getDriverPlateLicense;
    private int getDriverAge, getDriverPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride);
    }

    public void makeDriverRegister(View view){
        Intent intent = new Intent(this, OfferRide2.class);

        //PEGAR OS DADOS FORNECIDOS PELO USUARIO E GUARDA EM VARIAVEIS
        EditText getName = (EditText) findViewById(R.id.name_complete);
        getDriverName = getName.getText().toString();

        EditText getEmail = (EditText) findViewById(R.id.driver_email);
        getDriverEmail = getEmail.getText().toString();

        EditText getAge = (EditText) findViewById(R.id.driver_age);
        int ageint = Integer.parseInt(getAge.getText().toString());
        getDriverAge = ageint;

        EditText getPhone = (EditText) findViewById(R.id.driver_license_plate);
        int phoneInt = Integer.parseInt(getAge.getText().toString());
        getDriverPhoneNumber = phoneInt;

        EditText getCarModel = (EditText) findViewById(R.id.driver_model_car);
        getDriverCarModel = getCarModel.getText().toString();

        EditText getCarColor = (EditText) findViewById(R.id.driver_model_color);
        getDriverCarColor = getCarColor.getText().toString();

        EditText getCarPlate = (EditText) findViewById(R.id.driver_license_plate);
        getDriverPlateLicense = getCarPlate.getText().toString();

        startActivity(intent);
    }
}
