package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class showRides extends Fragment{

    private String origin, destiny;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_show_rides,
                container, false);
        Bundle bundle = getActivity().getIntent().getExtras();
        //Extract the data…
        origin = bundle.getString("origin");
        destiny = bundle.getString("destiny");
        Log.d(TAG,"Before list Rides");
        listRides(view);
        return view;
    }

    private  void listRides(final View v){

        RideControl rc= new RideControl();
        ArrayList<Ride> availableRides = rc.showRides(origin,destiny);
        if(availableRides.size()==0)
             Log.d(TAG,"NO AVAILABLE RIDE");
      //  Log.d(TAG,"Before ridesAdapter");

         RideAdapterItem ridesAdapter = new RideAdapterItem(v.getContext(),availableRides);
        final ListView ridesResult = (ListView) v.findViewById(R.id.ridesResult);
        Log.d(TAG,"Rides size = "+ availableRides.size());

        ridesResult.setAdapter(ridesAdapter);
        final AlertDialog.Builder myAlert = new AlertDialog.Builder(v.getContext());

        ridesResult.setOnItemClickListener (new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {
                Log.d(TAG,"WHERE's jubileu's house?");
                Ride result = (Ride) ridesResult.getItemAtPosition(position);
                myAlert.setMessage("Motorista: " + result.getDriver().getName())
                        .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setTitle("Carona Confirmada")
                        .create()
                        ;
                myAlert.show();
            }
        });
    }
}
