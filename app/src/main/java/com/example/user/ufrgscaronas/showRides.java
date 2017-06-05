package com.example.user.ufrgscaronas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import controllers.RideControl;
import dao.RideDao;
import model.Ride;
import util.RideAdapterItem;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class showRides extends AppCompatActivity {

    private String origin, destiny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rides);

        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        //Extract the data…
        origin = bundle.getString("origin");
        destiny = bundle.getString("destiny");
        Log.d(TAG,"Before list Rides");
        listRides();
    }

    private  void listRides(){

        RideControl rc= new RideControl();
        ArrayList<Ride> availableRides = rc.showRides(origin,destiny);
        if(availableRides.size()==0)
             Log.d(TAG,"NO AVAILABLE RIDE");
      //  Log.d(TAG,"Before ridesAdapter");

         RideAdapterItem ridesAdapter = new RideAdapterItem(this,availableRides);
        ListView ridesResult = (ListView) findViewById(R.id.ridesResult);
        Log.d(TAG,"Rides size = "+ availableRides.size());

        ridesResult.setAdapter(ridesAdapter);

    }
}
