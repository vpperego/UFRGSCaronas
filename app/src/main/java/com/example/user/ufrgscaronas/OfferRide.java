package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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


/**
 * Classe Oferecer Carona (OfferRide). Classe responsável
 * por possibilitar o usuário a se inscrever e torná-lo apto
 * a poder oferecer carona a estudantes.
 *
 */
public class OfferRide extends Fragment {

    private String getDriverName, getDriverEmail,getDriverPhoneNumber;
    private int getDriverAge;


    public OfferRide(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_offer_ride,
                container, false);


        Button offerRideB = (Button )view.findViewById(R.id.offerRideB);
        offerRideB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                makeDriverRegister(view);
            }
        });
        return view;
    }


    /**
     * Realiza o cadastro básico para o usuário ser possibilitado de
     * oferecer carona.
     *
     * Pega todos os dados de entrada que o usuário escreveu, e joga
     * num banco de dados.
     *
     * @param-> view
     */
    public void makeDriverRegister(View v){

        Fragment offerRide2 = new OfferRide2();

        //PEGA CADA CAMPO FORNECIDO PELO USUARIO E GUARDA EM UMA VARIAVEL
        EditText getName = (EditText) v.findViewById(R.id.name_complete);
        getDriverName = getName.getText().toString();


        //PARA CADA CAMPO, SE NADA FOI DIGITADO, MENSAGEM SERA EXIBIDA INFORMANDO QUE O CAMPO
        //É OBRIGATÓRIO!
        if(TextUtils.isEmpty(getDriverName)) {
            getName.setError("Este campo é obrigatório!");
            return;
        }


        EditText getEmail = (EditText) v.findViewById(R.id.driver_email);
        getDriverEmail = getEmail.getText().toString();

        if(TextUtils.isEmpty(getDriverEmail)) {
            getEmail.setError("Este campo é obrigatório!");
            return;
        }


        EditText getAge = (EditText) v.findViewById(R.id.driver_age);
        if(TextUtils.isEmpty(getAge.getText().toString())) {
            getAge.setError("Este campo é obrigatório!");
            return;
        }
        int ageint = Integer.parseInt(getAge.getText().toString());
        getDriverAge = ageint;


        EditText getPhone = (EditText) v.findViewById(R.id.driver_phone);
        if(TextUtils.isEmpty(getPhone.getText().toString())){
            getPhone.setError("Este campo é obrigatório!");
            return;
        }
        getDriverPhoneNumber= getPhone.getText().toString();


        //Grava o dado do nome do motorista para passar a próxima etapa.
        Bundle bundle = new Bundle();
        String myMessage = getDriverName;
        bundle.putString("nameDriver", myMessage );
        offerRide2.setArguments(bundle);


        //Vai para a segunda etapa do cadastro do motorista
        // Cria um nova transação
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        //Realiza a transição e coloca na pilha os eventos anteriores.
        transaction.replace(R.id.constraint_main, offerRide2);
        transaction.addToBackStack(null);

        // Comita a transação
        Log.d(TAG,"Fazendo commit...");
        transaction.commit();
    }

}
