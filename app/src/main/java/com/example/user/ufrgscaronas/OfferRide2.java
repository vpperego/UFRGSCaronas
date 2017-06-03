package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class OfferRide2 extends AppCompatActivity {

    private String getDriverDate, getDriverHour, getDriverDeparturePlace, getDriverArrivalPlace;
    private int maxPassangers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride2);

        Spinner dropdownDeparture = (Spinner)findViewById(R.id.spinner_Partida_Info);
        String[] itemsDeparture = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsDeparture);
        dropdownDeparture.setAdapter(adapter);

        Spinner dropdownArrival = (Spinner)findViewById(R.id.spinner_chegada_info);
        String[] itemsArrival = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsArrival);
        dropdownArrival.setAdapter(adapter1);
    }

    public void finalizeDriverRegister(View view){
        Intent intent = new Intent(this, MainProgram.class);

        //PEGAR OS DADOS FORNECIDOS E JOGAR NO BANCO DE DADOS
        Spinner dropdownDeparture = (Spinner)findViewById(R.id.spinner_Partida_Info);
        /////
        Spinner dropdownArrival = (Spinner)findViewById(R.id.spinner_chegada_info);
        /////




        EditText getHour = (EditText) findViewById(R.id.hour_departure);
        getDriverHour = getHour.getText().toString();

        EditText getDate = (EditText) findViewById(R.id.date_departure);
        getDriverDate = getDate.getText().toString();

        EditText getAge = (EditText) findViewById(R.id.driver_age);
        int maxint = Integer.parseInt(getAge.getText().toString());
        maxPassangers = maxint;




        //MENSAGEM DE SUCESSO QUE O CADASTRO FOI FINALIZADO


        startActivity(intent);
    }

}
