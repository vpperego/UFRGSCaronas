package com.example.user.ufrgscaronas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import dao.RideDao;
import model.Ride;

public class showRides extends AppCompatActivity {

    private String origin, destiny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rides);

        //Get the bundle
   //     Bundle bundle = getIntent().getExtras();

        //Extract the data…
     //   origin = bundle.getString("origin");
     //   destiny = bundle.getString("destiny");
      //  listRides();
    }

    private  void listRides(){
        RideDao rd = new RideDao();
        ArrayList<Ride> availableRides = rd.searchRide(origin,destiny);
        ListAdapter ridesAdapter = new ArrayAdapter<Ride>(this,android.R.layout.simple_list_item_1,availableRides);//TODO - change the simple_list_item1 to a better model
        ListView ridesResult = (ListView) findViewById(R.id.ridesResult);
        ridesResult.setAdapter(ridesAdapter);
    }
}
