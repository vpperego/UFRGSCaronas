package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import controllers.UserControl;
import controllers.VehicleControl;
import model.User;
import model.Vehicle;

import static android.content.ContentValues.TAG;


/**
 * Classe Oferecer Carona (OfferRide). Classe responsável
 * por possibilitar o usuário a se inscrever e torná-lo apto
 * a poder oferecer carona a estudantes.
 *
 */
public class OfferRide extends Fragment {

    private String getDriverName, getDriverEmail;
    private int getDriverAge, getDriverPhoneNumber;


    public OfferRide(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_offer_ride,
                container, false);
        return view;
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
        /*
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
        if(TextUtils.isEmpty(getAge.getText().toString())) {
            getAge.setError("Este campo é obrigatório!");
            return;
        }
        int ageint = Integer.parseInt(getAge.getText().toString());
        getDriverAge = ageint;


        EditText getPhone = (EditText) findViewById(R.id.driver_phone);
        if(TextUtils.isEmpty(getPhone.getText().toString())){
            getPhone.setError("Este campo é obrigatório!");
            return;
        }
        int phoneInt = Integer.parseInt(getPhone.getText().toString());
        getDriverPhoneNumber = phoneInt;


        offerRide2Intent.putExtra("NAME_ID", getDriverName);
        startActivity(offerRide2Intent);
        */
    }

}
