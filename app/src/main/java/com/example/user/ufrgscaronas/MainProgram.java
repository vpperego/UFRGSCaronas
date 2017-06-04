package com.example.user.ufrgscaronas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


/**
 * Classe MainProgram. Classe Principal do programa. É a tela onde
 * redicionará o usuário para a ação desejada. Seja de oferecer uma
 * carona, como buscar ela.
 *
 */
public class MainProgram extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Método responsável por ir para a ação de oferecer carona.
     * No momento em que o usuário clica no botão de ação de oferecer, este
     * método é chamado.
     *
     * @param view
     */
    public void goToOfferARide(View view){
        Intent intent = new Intent(this, OfferRide.class);
        startActivity(intent);
    }

    /**
     * Método responsável por ir para a ação de procurar carona.
     * No momento em que o usuário clica no botão de ação de procurar, este
     * método é chamado.
     *
     * @param view
     */
    public void goToSearchRide(View view){
        Intent intent = new Intent(this, SearchRide.class);
        startActivity(intent);
    }


}
