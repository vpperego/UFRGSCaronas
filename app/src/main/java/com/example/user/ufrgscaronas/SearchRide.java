package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchRide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ride);

        Spinner dropdownDeparture = (Spinner)findViewById(R.id.spinnerPartida);
        String[] itemsDeparture = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsDeparture);
        dropdownDeparture.setAdapter(adapter);

        Spinner dropdownArrival = (Spinner)findViewById(R.id.spinnerChegada);
        String[] itemsArrival = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsArrival);
        dropdownArrival.setAdapter(adapter1);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainProgram.class);
        startActivity(intent);
    }

    public void checkRide(){




    }
}
