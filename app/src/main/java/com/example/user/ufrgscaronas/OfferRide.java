package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;


/**
 * Classe Oferecer Carona (OfferRide).
 *
 */
public class OfferRide extends AppCompatActivity {

    private String getDriverName, getDriverEmail, getDriverCarModel, getDriverCarColor, getDriverPlateLicense;
    private int getDriverAge, getDriverPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride);
    }


    /**
     * Realiza o cadastro básico para o usuário ser possibilitado de
     * oferecer carona.
     *
     * Pega todos os dados de entrada que o usuário escreveu, e joga
     * num banco de dados.
     *
     * @param view
     */
    public void makeDriverRegister(View view){
        Intent offerRide2Intent = new Intent(this, OfferRide2.class);

        //PEGA CADA CAMPO FORNECIDO PELO USUARIO E GUARDA EM UMA VARIAVEL
        EditText getName = (EditText) findViewById(R.id.name_complete);
        getDriverName = getName.getText().toString();

        //PARA CADA CAMPO, SE NADA FOI DIGITADO, MENSAGEM SERA EXIBIDA INFORMANDO QUE O CAMPO
        //É OBRIGATÓRIO!
        if(TextUtils.isEmpty(getDriverName)) {
            getName.setError("Este campo é obrigatório!");
            return;
        }

        EditText getEmail = (EditText) findViewById(R.id.driver_email);
        getDriverEmail = getEmail.getText().toString();

        if(TextUtils.isEmpty(getDriverEmail)) {
            getEmail.setError("Este campo é obrigatório!");
            return;
        }

        EditText getAge = (EditText) findViewById(R.id.driver_age);
        int ageint = Integer.parseInt(getAge.getText().toString());
        getDriverAge = ageint;

        if(TextUtils.isEmpty(getAge.getText().toString())){
            getAge.setError("Este campo é obrigatório!");
            return;
        }

        EditText getPhone = (EditText) findViewById(R.id.driver_phone);
        int phoneInt = Integer.parseInt(getPhone.getText().toString());
        getDriverPhoneNumber = phoneInt;

        if(TextUtils.isEmpty(getPhone.getText().toString())){
            getPhone.setError("Este campo é obrigatório!");
            return;
        }

        EditText getCarModel = (EditText) findViewById(R.id.driver_model_car);
        getDriverCarModel = getCarModel.getText().toString();

        if(TextUtils.isEmpty(getDriverCarModel)){
            getCarModel.setError("Este campo é obrigatório!");
            return;
        }

        EditText getCarColor = (EditText) findViewById(R.id.driver_model_color);
        getDriverCarColor = getCarColor.getText().toString();

        if(TextUtils.isEmpty(getDriverCarColor)){
            getCarColor.setError("Este campo é obrigatório!");
            return;
        }

        EditText getCarPlate = (EditText) findViewById(R.id.driver_license_plate);
        getDriverPlateLicense = getCarPlate.getText().toString();

        if(TextUtils.isEmpty(getDriverPlateLicense)){
            getCarPlate.setError("Este campo é obrigatório!");
            return;
        }

        startActivity(offerRide2Intent);
    }
}
