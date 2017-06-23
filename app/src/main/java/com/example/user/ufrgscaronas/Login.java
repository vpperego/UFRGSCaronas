package com.example.user.ufrgscaronas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
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

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

       String filename = "users_accounts.txt";
       String string = "admin;Não Informado;admin@admin.com;admin\n";
       FileOutputStream outputStream;

       try {
           outputStream = openFileOutput(filename, Context.MODE_APPEND);
           outputStream.write(string.getBytes());
           outputStream.close();
       } catch (Exception e) {
           e.printStackTrace();
       }



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


    /**
     * Método que realiza o login de um usuário. Faz a verificação do
     * email e da senha digitados pelo usuário, e caso corretos, seu
     * login será realizado. Caso contrário, um erro será informado.
     *
     * @param view
     */
    public void makeLogin(View view) {

        Intent startProgram = new Intent(this, drawer.class);


        //Pega os campos de Email e Senha que serão digitados pelo usuário
        EditText user_email = (EditText)findViewById(R.id.type_email);
        EditText user_password = (EditText)findViewById(R.id.type_password);

        //Transforma em String o campo user_email (EditText) acima.
        String useremail = user_email.getText().toString();

        //Verifica se o campo email é não vazio
        if(TextUtils.isEmpty(useremail)){
            user_email.setError("Insira um email");
            return;
        }

        //Transforma em String o campo user_password (EditText) acima.
        String userpass = user_password.getText().toString();

        //Verifica se o campo senha é não vazio
        if(TextUtils.isEmpty(userpass)){
            user_password.setError("Informe sua senha");
            return;
        }


        //Lê no banco de dados dos usuários cadastrados e procura pelo usuário com aquele email
        //e senha digitados. Caso correto, o usuário se logará ao aplicativo. Caso contrário,
        //uma mensagem informando o motivo do porquê o usuário não conseguiu logar será exibida.
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("users_accounts.txt")));
            String line;
            Log.e("Reader Stuff", reader.readLine());
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                Log.e("code", line);
                String user_info[] = line.split(";");

                if (user_info[2].equals(user_email.getText().toString())){
                    found = true;
                    if(user_info[3].equals(user_password.getText().toString())){
                        startProgram.putExtra("complete_name", user_info[0]);
                        startProgram.putExtra("user_age", user_info[1]);
                        startProgram.putExtra("email", user_info[2]);

                        startActivity(startProgram);
                        finish();
                    } else{
                        user_password.setError("Senha inválida!");
                    }

                }
            }
            if(found == false) {
                user_password.setError("Email associado não encontrado ou inválido!");
            }
        } catch (IOException e ){
            user_password.setError(".");
        }

        //SE TUDO CERTO, INICIA ACTIVITY PRINCIPAL

    }


    /**
     * Método que ativa a activity para criar o primeiro acesso ao aplicativo.
     * Levará o novo usuário para realizar um cadastro para criar uma nova conta.
     *
     * @param v
     */
    public void openFTLogin(View v){
        Log.d(TAG,"ON CLICK FOR OTHER");

       Intent registerNewUser = new Intent(this, FirstTimeLogin.class);
       startActivity(registerNewUser);
    }


}