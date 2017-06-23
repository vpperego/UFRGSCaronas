package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Classe MainProgram. Classe Principal do programa. É a tela onde
 * redicionará o usuário para a ação desejada. Seja de oferecer uma
 * carona, como buscar ela.
 *
 */
public class MainProgram extends Fragment {

    private String name_info, age_info, email_info;

    public MainProgram(){


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,
                container, false);

        Button giveRide = (Button )view.findViewById(R.id.giveRide);
        Button takeRide = (Button )view.findViewById(R.id.takeRide);
        giveRide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToOfferARide(v);
            }
        });
        takeRide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToSearchRide(v);
            }
        });

        return view;
    }

    /**
     * Método responsável por ir para a ação de oferecer carona.
     * No momento em que o usuário clica no botão de ação de oferecer, este
     * método é chamado.
     *
     * @param view
     */
    public void goToOfferARide(View view){
        // Cria um novo fragmento e transação
        Fragment offerRide = new OfferRide();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        //Realiza a transição e coloca na pilha os eventos anteriores.
        transaction.replace(R.id.constraint_main, offerRide);
        transaction.addToBackStack(null);

        // Comita a transação
        transaction.commit();
    }


    /**
     * Método responsável por ir para a ação de procurar carona.
     * No momento em que o usuário clica no botão de ação de procurar, este
     * método é chamado.
     *
     * @param view
     */
    public void goToSearchRide(View view){

        //Gera uma nova transação e fragment
        Fragment searchRide = new SearchRide();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        //Realiza a transição e coloca na pilha os eventos anteriores.
        transaction.replace(R.id.constraint_main, searchRide);
        transaction.addToBackStack(null);

        // Comita a transação
        transaction.commit();
    }


}
