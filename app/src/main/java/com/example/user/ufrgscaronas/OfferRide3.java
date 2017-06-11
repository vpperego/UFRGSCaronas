package com.example.user.ufrgscaronas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
public class OfferRide3 extends AppCompatActivity {

    private String getDriverDate, getDriverHour, getDriverDeparturePlace, getDriverArrivalPlace;
    private int maxPassangers;
    public Intent registerEnd;
    private User driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride3);
        Log.d(TAG,"ENTRANDO OFFERRIDE3");
        //LISTA AS OPÇÕES DE PONTO DE PARTIDA E PONTO DE CHEGADA.
        Spinner dropdownDeparture = (Spinner)findViewById(R.id.spinner_Partida_Info);
        String[] itemsDeparture = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsDeparture);
        dropdownDeparture.setAdapter(adapter);

        Spinner dropdownArrival = (Spinner)findViewById(R.id.spinner_chegada_info);
        String[] itemsArrival = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsArrival);
        dropdownArrival.setAdapter(adapter1);

        readStrings();
     }

    void readStrings()
    {

        Bundle bundle = getIntent().getExtras();

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
    public void confirmRegister(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Cadastro realizado com sucesso! Obrigado por se tornar um motorista do UFRGS Caronas!" +
                "\n\nCaso alguem lhe solicite carona, você receberá uma notificação no seu celular!");
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(registerEnd);
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
    public void finalizeDriverRegister(View view){
        registerEnd = new Intent(this, MainProgram.class);

        //PEGA CADA CAMPO FORNECIDO PELO USUARIO E GUARDA EM UMA VARIAVEL
        Spinner dropdownDeparture = (Spinner)findViewById(R.id.spinner_Partida_Info);
        getDriverDeparturePlace = dropdownDeparture.getSelectedItem().toString();

        Spinner dropdownArrival = (Spinner)findViewById(R.id.spinner_chegada_info);
        getDriverArrivalPlace = dropdownArrival.getSelectedItem().toString();


        //PARA CADA CAMPO, SE NADA FOI DIGITADO, MENSAGEM SERA EXIBIDA INFORMANDO QUE O CAMPO
        //É OBRIGATÓRIO!

        if (getDriverDeparturePlace.equals(getDriverArrivalPlace)){
            TextView errorText = (TextView) dropdownArrival.getSelectedView();
            errorText.setError("Campus iguais!!");
            return;
        }

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

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
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


                        confirmRegister();
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