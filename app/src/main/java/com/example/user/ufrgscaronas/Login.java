package com.example.user.ufrgscaronas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;
import static android.content.ContentValues.TAG;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity {

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_login,
                container, false);

        Button ftButton = (Button) view.findViewById(R.id.ftLogin);
        Button mainButton = (Button) view.findViewById(R.id.mainLogin);
        ftButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openFTLogin(v);
            }
        });

        mainButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                makeLogin(v);
            }
        });
        return view;
    }
*/
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);

       Button ftButton = (Button) findViewById(R.id.ftLogin);
       Button mainButton = (Button) findViewById(R.id.mainLogin);
       ftButton.setOnClickListener(new OnClickListener() {
               @Override
               public void onClick(View v) {
                   openFTLogin(v);
               }
           });

       mainButton.setOnClickListener(new OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               makeLogin(v);
           }
       });
   }

    public void recoverMyPassword(View view){
        return;
    }



    public void makeLogin(View view){

        Intent startProgram = new Intent(this, drawer.class);

        //TODO CHECK MY LOGIN



        //SE TUDO CERTO, INICIA ACTIVITY PRINCIPAL
        startActivity(startProgram);
    }


    public void openFTLogin(View v){
        Log.d(TAG,"ON CLICK FOR OTHER");
        Fragment ftLogin = new FirstTimeLogin();
        //FragmentManager manager = getFragmentManager();
        //manager.beginTransaction().replace(R.id.constraint_main,ftLogin).commit();


        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        //Realiza a transição e coloca na pilha os eventos anteriores.
        transaction.replace(R.id.ftLogin, ftLogin);
        transaction.addToBackStack(null);

        // Comita a transação
        transaction.commit();

        //Intent registerNewUser = new Intent(this, FirstTimeLogin.class);
       //startActivity(registerNewUser);
    }


}