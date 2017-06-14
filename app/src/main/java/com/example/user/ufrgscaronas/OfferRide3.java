package com.example.user.ufrgscaronas;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import controllers.RideControl;
import model.User;

import static android.content.ContentValues.TAG;

/**
 * Classe OfferRide3. Esta classe é responsável por possibilitar o motorista
 * a informar seus dados sobre onde e quando sua carona pode ser executada
 * (dando data, hora, lugar de partida e chegada).
 *
 */
public class OfferRide3 extends Fragment {

    private String getDriverDate, getDriverHour, getDriverDeparturePlace, getDriverArrivalPlace;
    private int maxPassangers;
    private Fragment registerEnd;
    private User driver;

    public OfferRide3(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_offer_ride3,
                container, false);


        //LISTA AS OPÇÕES DE PONTO DE PARTIDA E PONTO DE CHEGADA.
        Spinner dropdownDeparture = (Spinner)view.findViewById(R.id.spinner_Partida_Info);
        String[] itemsDeparture = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, itemsDeparture);
        dropdownDeparture.setAdapter(adapter);

        Spinner dropdownArrival = (Spinner)view.findViewById(R.id.spinner_chegada_info);
        String[] itemsArrival = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, itemsArrival);
        dropdownArrival.setAdapter(adapter1);


        //Lê os dados passados anteriormente
        readStrings();


        //Ação para finalizar o cadastro quando o usuário apertar o botão
        Button offerRideB3 = (Button )view.findViewById(R.id.offerRideB3);
        offerRideB3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finalizeDriverRegister(view);
            }
        });
        return view;
    }


    void readStrings()
    {

        //Bundle bundle = getActivity().getIntent().getExtras();
        Bundle bundle = getArguments();

        driver = new User();
        driver.setId(bundle.getInt("id"));
        driver.setName(bundle.getString("name"));
        driver.setScore(bundle.getDouble("score"));
        driver.getVehicle().setName(bundle.getString("carName"));
        driver.getVehicle().setPlate(bundle.getString("carPlate"));
        driver.getVehicle().setColor(bundle.getString("carColor"));
        driver.getVehicle().setMaximummaximumPassagers(bundle.getInt("carPassagers"));
    }


    /**
     * Confirma o cadastro do usuário. Apresenta uma mensagem de agradecimento
     * e volta a página inicial do programa.
     *
     */
    public void confirmRegister(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
        builder1.setMessage("Cadastro realizado com sucesso! Obrigado por se tornar um motorista do UFRGS Caronas!" +
                "\n\nCaso alguem lhe solicite carona, você receberá uma notificação no seu celular!");
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Finaliza o registro do motorista
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();

                        //Realiza a transição e coloca na pilha os eventos anteriores.
                        transaction.replace(R.id.constraint_main, registerEnd);
                        transaction.addToBackStack(null);

                        // Comita a transação
                        transaction.commit();
                     }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


    /**
     * Finaliza o cadastro de um motorista. Sempre que o motorista desejar oferecer carona,
     * ele deve informar os campos do formulário.
     *
     * @param view
     */
    public void finalizeDriverRegister(final View view){
        registerEnd = new MainProgram();

        //PEGA CADA CAMPO FORNECIDO PELO USUARIO E GUARDA EM UMA VARIAVEL
        Spinner dropdownDeparture = (Spinner)view.findViewById(R.id.spinner_Partida_Info);
        getDriverDeparturePlace = dropdownDeparture.getSelectedItem().toString();

        Spinner dropdownArrival = (Spinner) view.findViewById(R.id.spinner_chegada_info);
        getDriverArrivalPlace = dropdownArrival.getSelectedItem().toString();


        //PARA CADA CAMPO, SE NADA FOI DIGITADO, MENSAGEM SERA EXIBIDA INFORMANDO QUE O CAMPO
        //É OBRIGATÓRIO!
        if (getDriverDeparturePlace.equals(getDriverArrivalPlace)){
            TextView errorText = (TextView) dropdownArrival.getSelectedView();
            errorText.setError("Campus iguais!!");
            return;
        }

        EditText getMax = (EditText) view.findViewById(R.id.passangers_max);

        if(TextUtils.isEmpty(getMax.getText().toString())){
            getMax.setError("Este campo é obrigatório!");
            return;
        }

        int maxint = Integer.parseInt(getMax.getText().toString());
        maxPassangers = maxint;


        EditText getDate = (EditText) view.findViewById(R.id.date_departure);
        getDriverDate = getDate.getText().toString();

        if(TextUtils.isEmpty(getDriverDate)){
            getDate.setError("Este campo é obrigatório!");
            return;
        }

        EditText getHour = (EditText) view.findViewById(R.id.hour_departure);
        getDriverHour = getHour.getText().toString();

        if(TextUtils.isEmpty(getDriverHour)){
            getHour.setError("Este campo é obrigatório!");
            return;
        }

        AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
        builder1.setMessage("Confirmar todos os dados?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "CONFIRMAR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //GUARDAR TODOS OS DADOS DE ENTRADA DADOS NO BANCO DE DADOS




                        //.....
                    //TODO - salvar data de maneira correta
                        RideControl rc = new RideControl();
                        rc.saveRide(driver,getDriverDeparturePlace, getDriverArrivalPlace);
                        //TERMINAR TUDO


                        confirmRegister(view);
                    }
                });

        builder1.setNegativeButton(
                "CANCELAR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

        //MENSAGEM DE SUCESSO QUE O CADASTRO FOI FINALIZADO



    }

}
