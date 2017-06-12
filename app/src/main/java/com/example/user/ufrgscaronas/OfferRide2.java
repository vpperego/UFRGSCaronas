package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import controllers.UserControl;
import controllers.VehicleControl;
import model.User;
import model.Vehicle;

import static android.content.ContentValues.TAG;

public class OfferRide2 extends Fragment {


    private String getDriverName2, getDriverCarModel, getDriverCarColor, getDriverPlateLicense;
    private Bundle extras;

    public OfferRide2(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_offer_ride2,
                container, false);
        Button offerRideB2 = (Button )view.findViewById(R.id.offerRideB2);
        offerRideB2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                carModelRegister(view);
            }
        });

        return view;
    }



    public void carModelRegister (View v){

        Fragment offerRide3 = new OfferRide3();


        EditText getCarModel = (EditText) v.findViewById(R.id.driver_model_car);
        getDriverCarModel = getCarModel.getText().toString();

        if(TextUtils.isEmpty(getDriverCarModel)){
            getCarModel.setError("Este campo é obrigatório!");
            return;
        }

        EditText getCarColor = (EditText) v.findViewById(R.id.driver_model_color);
        getDriverCarColor = getCarColor.getText().toString();

        if(TextUtils.isEmpty(getDriverCarColor)){
            getCarColor.setError("Este campo é obrigatório!");
            return;
        }

        EditText getCarPlate = (EditText) v.findViewById(R.id.driver_license_plate);
        getDriverPlateLicense = getCarPlate.getText().toString();

        if(TextUtils.isEmpty(getDriverPlateLicense)){
            getCarPlate.setError("Este campo é obrigatório!");
            return;
        }


        String getDriverName2 = getActivity().getIntent().getStringExtra("NAME_ID");


        VehicleControl vc= new VehicleControl();
        Vehicle riderVehicle = vc.saveVehicle(getDriverCarModel,getDriverPlateLicense,getDriverCarColor,4);
        UserControl uc = new UserControl();
        Log.d(TAG,"Driver name = " + getDriverName2);
        User newRider =uc.saveUser(getDriverName2,5.0,riderVehicle);
        Log.d(TAG,"Driver name 2 = " + newRider.getName());

        extras  = new Bundle();
        extras.putString("name",newRider.getName());
        extras.putInt("id",newRider.getId());
        extras.putDouble("score",newRider.getScore());
        extras.putString("carName",newRider.getVehicle().getName());
        extras.putString("carPlate",newRider.getVehicle().getPlate());
        extras.putString("carColor",newRider.getVehicle().getColor());
        extras.putInt("carPassagers",newRider.getVehicle().getMaximumPasangers());


        getActivity().getIntent().putExtras(extras);
        //saveUser(String name, double score, Vehicle vehicle)
        //saveUser(String name, String plate, String color, int maximumPassagers)

        // ENCERRA E VAI PRA PROXIMA ETAPA
        FragmentManager manager = getFragmentManager ();
        manager.beginTransaction().replace(R.id.constraint_main,offerRide3).commit();



    }

}
