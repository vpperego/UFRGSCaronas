package com.example.user.ufrgscaronas;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

import static android.content.ContentValues.TAG;

public class FirstTimeLogin extends AppCompatActivity {

    private Intent makeNewUser;
    private String newUserName, newUserEmail, newUserAge, userPassword, userConfirmPassword;

    public FirstTimeLogin(){
        //required empty constructor
        Log.d(TAG,"NO CONSTRUCTOR EMPTY");
    }

    /*
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.activity_first_time_login,
                container, false);

        Button FTRegister = (Button )view.findViewById(R.id.FTRegisterButton);
        FTRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                registerNewUser(view);
            }
        });
        return view;

    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_login);

        Button FTRegister = (Button )findViewById(R.id.FTRegisterButton);
        FTRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                registerNewUser(v);
            }
        });
    }



    public void makeLogin(View view){
        Intent startProgram = new Intent(this, MainProgram.class);

        //Fragment fragment = new YourFragment();

        //FragmentManager fm = getSupportFragmentManager();
        //FragmentTransaction transaction = fm.beginTransaction();
        //transaction.replace(R.id.contentFragment, fragment);
        //transaction.commit();
        //SE TUDO CERTO, INICIA ACTIVITY PRINCIPAL
        startActivity(startProgram);
    }


    public void registerNewUser(final View v){
        makeNewUser = new Intent(this, Login.class);


        // Confirmação de que os campos foram preenchidos e não estão nulos
        EditText username = (EditText) findViewById(R.id.newUserNameField);
        newUserName = username.getText().toString();

        if(TextUtils.isEmpty(newUserName)){
            username.setError("Este campo é obrigatório!");
            return;
        }

        EditText userEmail = (EditText) findViewById(R.id.newUserEmailField);
        newUserEmail = userEmail.getText().toString();

        if(TextUtils.isEmpty(newUserEmail)){
            userEmail.setError("Este campo é obrigatório!");
            return;
        }


        EditText userAge = (EditText) findViewById(R.id.newUserAgeField);
        newUserAge = userAge.getText().toString();


        EditText userPasswrd = (EditText) findViewById(R.id.newUserPasswrdField);
        userPassword = userPasswrd.getText().toString();

        if(TextUtils.isEmpty(userPassword)){
            userPasswrd.setError("Este campo é obrigatório!");
            return;
        }

        EditText userConfirmationPasswrd = (EditText) findViewById(R.id.newUserConfirmPasswrdField);
        userConfirmPassword = userConfirmationPasswrd.getText().toString();

        if(TextUtils.isEmpty(userConfirmPassword)){
            userConfirmationPasswrd.setError("Este campo é obrigatório!");
            return;
        }


        if(TextUtils.isEmpty(newUserAge)){
            newUserAge = "Não Informado";
        }

        /////////////////////////////////////////////////////////////////////


        //Confirmação de que a senha de confirmação é identica a senha fornecida no campo anterior.
        //Se correto, prossegue o processe para confirmação de cadastro. Caso Contrário, notifica
        //que as senhas são diferentes.
        if (userPassword.equals(userConfirmPassword)) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
            builder1.setMessage("Confirmar todos os campos?");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "CONFIRMAR",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            //GUARDAR TODOS OS DADOS DE ENTRADA DADOS NO BANCO DE
                            String filename = "users_accounts.txt";
                            String string = newUserName+";"+newUserAge+";"+ newUserEmail+";"+userPassword+"\n";
                            FileOutputStream outputStream;

                            try {
                                outputStream = openFileOutput(filename, Context.MODE_APPEND);
                                outputStream.write(string.getBytes());
                                outputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }





                            //APÓS RETOMAR AO MENU INICIAL PARA O USUARIO ENTRAR COM SEU EMAIL E SENHA CRIADOS
                            backToLogin(v);
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
        } else {
            userConfirmationPasswrd.setError("Senha de confirmação diferente da senha acima!");
            return;
        }

    }


    public void backToLogin(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
        builder1.setMessage("Cadastro realizado com sucesso! \nInsira seu email e senha " +
                "informados para ter o acesso ao UFRGS Caronas!");
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(makeNewUser);

                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

}
