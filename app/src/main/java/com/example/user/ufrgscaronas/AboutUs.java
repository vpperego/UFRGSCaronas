package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;


/**
 * Classe AboutUs. Responsável por exibir informações sobre o aplicativo.
 *
 */
public class AboutUs extends Fragment {

    public AboutUs(){
        //required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_about_us, container, false);
    }
}
