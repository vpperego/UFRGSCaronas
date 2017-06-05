package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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
public class OfferRide extends AppCompatActivity {

    private String getDriverName, getDriverEmail, getDriverCarModel, getDriverCarColor, getDriverPlateLicense;
    private int getDriverAge, getDriverPhoneNumber;
    private Bundle extras;

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


        //GUARDAR VALORES DAS VARIAVES NO BANCO DE DADOS


        VehicleControl vc= new VehicleControl();
        Vehicle riderVehicle = vc.saveVehicle(getDriverCarModel,getDriverPlateLicense,getDriverCarColor,4);
        UserControl uc = new UserControl();
        Log.d(TAG,"Driver name = " + getDriverName);
        User newRider =uc.saveUser(getDriverName,5.0,riderVehicle);
        Log.d(TAG,"Driver name 2 = " + newRider.getName());

        extras  = new Bundle();
        extras.putString("name",newRider.getName());
        extras.putInt("id",newRider.getId());
        extras.putDouble("score",newRider.getScore());
        extras.putString("carName",newRider.getVehicle().getName());
        extras.putString("carPlate",newRider.getVehicle().getPlate());
        extras.putString("carColor",newRider.getVehicle().getColor());
        extras.putInt("carPassagers",newRider.getVehicle().getMaximumPasangers());

        //.......TO DO




       offerRide2Intent.putExtras(extras);

        //saveUser(String name, double score, Vehicle vehicle)
    //saveUser(String name, String plate, String color, int maximumPassagers)

        // ENCERRA E VAI PRA PROXIMA ETAPA
        Log.d(TAG,"BEFORE OFFERRIDE2");

        startActivity(offerRide2Intent);
    }
  //      public Vehicle(String name, String plate, String color, int maximumPassagers) {
  //public User(int id, String name, double score, Vehicle vehicle) {



}
