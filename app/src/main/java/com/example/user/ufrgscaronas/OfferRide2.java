package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Classe OfferRide2. Esta classe é responsável por possibilitar o motorista
 * a informar seus dados sobre onde e quando sua carona pode ser executada
 * (dando data, hora, lugar de partida e chegada).
 *
 */
public class OfferRide2 extends AppCompatActivity {

    private String getDriverDate, getDriverHour, getDriverDeparturePlace, getDriverArrivalPlace;
    private int maxPassangers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride2);


        //LISTA AS OPÇÕES DE PONTO DE PARTIDA E PONTO DE CHEGADA.
        Spinner dropdownDeparture = (Spinner)findViewById(R.id.spinner_Partida_Info);
        String[] itemsDeparture = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsDeparture);
        dropdownDeparture.setAdapter(adapter);

        Spinner dropdownArrival = (Spinner)findViewById(R.id.spinner_chegada_info);
        String[] itemsArrival = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsArrival);
        dropdownArrival.setAdapter(adapter1);
    }


    /**
     * Finaliza o cadastro de um motorista. Sempre que o motorista desejar oferecer carona,
     * ele deve informar os campos do formulário.
     *
     * @param view
     */
    public void finalizeDriverRegister(View view){
        Intent registerEnd = new Intent(this, MainProgram.class);

        //PEGA CADA CAMPO FORNECIDO PELO USUARIO E GUARDA EM UMA VARIAVEL
        //Spinner dropdownDeparture = (Spinner)findViewById(R.id.spinner_Partida_Info);
        //getDriverDeparturePlace = dropdownDeparture.getSelectedItem().toString();

        //Spinner dropdownArrival = (Spinner)findViewById(R.id.spinner_chegada_info);
        //getDriverArrivalPlace = dropdownDeparture.getSelectedItem().toString();


        //PARA CADA CAMPO, SE NADA FOI DIGITADO, MENSAGEM SERA EXIBIDA INFORMANDO QUE O CAMPO
        //É OBRIGATÓRIO!
        /**
        if (getDriverDeparturePlace.equals(getDriverArrivalPlace)){
            TextView errorText = (TextView) dropdownArrival.getSelectedView();
            errorText.setError("Campus iguais!!");
            return;
        }
         */



        EditText getMax = (EditText) findViewById(R.id.passangers_max);

        if(TextUtils.isEmpty(getMax.getText().toString())){
            getMax.setError("Este campo é obrigatório!");
            return;
        }

        int maxint = Integer.parseInt(getMax.getText().toString());
        maxPassangers = maxint;


        EditText getDate = (EditText) findViewById(R.id.date_departure);
        getDriverDate = getDate.getText().toString();

        if(TextUtils.isEmpty(getDriverDate)){
            getDate.setError("Este campo é obrigatório!");
            return;
        }

        EditText getHour = (EditText) findViewById(R.id.hour_departure);
        getDriverHour = getHour.getText().toString();

        if(TextUtils.isEmpty(getDriverHour)){
            getHour.setError("Este campo é obrigatório!");
            return;
        }

        //MENSAGEM DE SUCESSO QUE O CADASTRO FOI FINALIZADO


        startActivity(registerEnd);
    }

}
