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
        Log.d(TAG,"Origin String: "+origin);
        Log.d(TAG,"Destiny String: "+destiny);
        listRides();
    }

    private  void listRides(){

        RideControl rc= new RideControl();
        ArrayList<Ride> availableRides = rc.showRides(origin,destiny);
        if(availableRides.size()==0)
            Log.d(TAG,"NO AVAILABLE RIDE");
         ListAdapter ridesAdapter = new ArrayAdapter<Ride>(this,android.R.layout.simple_list_item_1,availableRides);//TODO - change the simple_list_item1 to a better model
        ListView ridesResult = (ListView) findViewById(R.id.ridesResult);
        ridesResult.setAdapter(ridesAdapter);
        /*
        String [] foods = {"bacon","ham","fruit","banana","potato"};
        ListAdapter ridesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foods);//TODO - change the simple_list_item1 to a better model
        ListView ridesResult = (ListView) findViewById(R.id.ridesResult);
        ridesResult.setAdapter(ridesAdapter);
        */
    }
}
