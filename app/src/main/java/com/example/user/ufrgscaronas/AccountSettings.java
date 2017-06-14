package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Classe AccountSettings. Responsável pela exibição de configurações que o
 * usuário poderá fazer no aplicativo.
 *
 */
public class AccountSettings extends Fragment {


    public AccountSettings(){
        //required empty constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_account_settings, container, false);
    }
}
