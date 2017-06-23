package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Classe que exibe o perfil com todos os dados do usuário.
 *
 */
public class MyProfile extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_my_profile, container,
                false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String showName = bundle.getString("name");
            String showAge = bundle.getString("age");
            String showEmail = bundle.getString("email");
            TextView tx1 = (TextView)view.findViewById(R.id.profile_name_id);
            TextView tx2 = (TextView)view.findViewById(R.id.email_profile_id);
            TextView tx3 = (TextView)view.findViewById(R.id.profile_age_id);

            tx1.setText(showName);
            tx2.setText(showEmail);
            tx3.setText(showAge);

        }



        return view;
    }
}
