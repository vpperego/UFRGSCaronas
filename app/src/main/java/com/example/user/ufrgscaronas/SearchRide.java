package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static com.example.user.ufrgscaronas.R.id.textView;


/**
 * Classe SearchRide. Esta classe é responsável por oferecer ao usuário
 * a possibilidade de buscar uma carona de um campus a outro. Dando
 * seu ponto de partida e chegada, e listando uma série de motoristas que
 * poderiam ser escolhidos para oferecer sua carona.
 *
 */
public class SearchRide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ride);

        //LISTA AS OPÇÕES DE PONTO DE PARTIDA E PONTO DE CHEGADA.
        Spinner dropdownDeparture = (Spinner)findViewById(R.id.spinnerOrigin);
        String[] itemsDeparture = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsDeparture);
        dropdownDeparture.setAdapter(adapter);

        Spinner dropdownArrival = (Spinner)findViewById(R.id.spinnerDestiny);
        String[] itemsArrival = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsArrival);
        dropdownArrival.setAdapter(adapter1);
        Button yourButton=(Button) findViewById(R.id.searchRide);
//set onclicklistener for your button
        yourButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkRide();
                    }
                });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainProgram.class);
        startActivity(intent);
    }


    public void checkRide(){
        Intent intent = new Intent(this, showRides.class);

         Spinner origin = (Spinner) findViewById(R.id.spinnerOrigin);
        Spinner destiny = (Spinner) findViewById(R.id.spinnerDestiny);

        Bundle bundle = new Bundle();

        bundle.putString("origin", origin.getSelectedItem().toString());
        bundle.putString("destiny", destiny.getSelectedItem().toString());
        intent.putExtras(bundle);

        startActivity(intent);

    }

}
