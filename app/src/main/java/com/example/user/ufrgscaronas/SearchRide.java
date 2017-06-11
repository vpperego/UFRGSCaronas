package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import static android.content.ContentValues.TAG;
import static com.example.user.ufrgscaronas.R.id.textView;


/**
 * Classe SearchRide. Esta classe é responsável por oferecer ao usuário
 * a possibilidade de buscar uma carona de um campus a outro. Dando
 * seu ponto de partida e chegada, e listando uma série de motoristas que
 * poderiam ser escolhidos para oferecer sua carona.
 *
 */
public class SearchRide extends Fragment {

    private String getRiderDeparturePlace, getRiderArrivalPlace;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_search_ride,
                container, false);
        //LISTA AS OPÇÕES DE PONTO DE PARTIDA E PONTO DE CHEGADA.
        Spinner dropdownDeparture = (Spinner)view.findViewById(R.id.spinnerOrigin);
        String[] itemsDeparture = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsDeparture);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_dropdown_item, itemsDeparture);
        dropdownDeparture.setAdapter(adapter);

        Spinner dropdownArrival = (Spinner) view.findViewById(R.id.spinnerDestiny);
        String[] itemsArrival = new String[]{"Campus Centro", "Campus Vale", "Campus ESEFID"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, itemsArrival);
        dropdownArrival.setAdapter(adapter1);
        Button yourButton=(Button) view.findViewById(R.id.searchRide);
         yourButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        checkRide(view);
                    }
                });


        return view;
    }
    /*
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

    //TODO
    @Override
    public void onBackPressed() {
        //Intent intent = new Intent(this, MainProgram.class);

        Fragment main = new MainProgram();
        FragmentManager manager = getFragmentManager ();
        manager.beginTransaction().replace(R.id.constraint_main,main).commit();

    }
*/
    //TODO
    public void checkRide(View v){

        Fragment showRides = new showRides();
         Spinner origin = (Spinner) v.findViewById(R.id.spinnerOrigin);
        if(origin==null)
            Log.d(TAG,"IS THIS REALLY NULL?");
        getRiderDeparturePlace = origin.getSelectedItem().toString();


        Spinner destiny = (Spinner) v.findViewById(R.id.spinnerDestiny);
        getRiderArrivalPlace = destiny.getSelectedItem().toString();

        if (getRiderDeparturePlace.equals(getRiderArrivalPlace)){
            TextView errorText = (TextView) destiny.getSelectedView();
            errorText.setError("Campus iguais!!");
            return;
        }

        /*
        Bundle bundle = new Bundle();

         bundle.putString("origin", origin.getSelectedItem().toString());
         bundle.putString("destiny", destiny.getSelectedItem().toString());
         intent.putExtras(bundle);
*/
        getActivity().getIntent().putExtra("origin", origin.getSelectedItem().toString());
        getActivity().getIntent().putExtra("destiny", destiny.getSelectedItem().toString());

        FragmentManager manager = getFragmentManager ();
        manager.beginTransaction().replace(R.id.constraint_main,showRides).commit();

    }

}
