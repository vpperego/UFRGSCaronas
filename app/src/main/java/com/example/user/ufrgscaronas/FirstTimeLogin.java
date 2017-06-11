package com.example.user.ufrgscaronas;

import android.app.Fragment;
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
import android.widget.EditText;

import static android.content.ContentValues.TAG;

public class FirstTimeLogin extends Fragment {

    private Intent makeNewUser;
    private String newUserName, newUserEmail, userPassword, userConfirmPassword;

    public FirstTimeLogin(){
        //required empty constructor
        Log.d(TAG,"NO CONSTRUCTOR EMPTY");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_first_time_login, container, false);
    }
/*
    public void makeLogin(View view){
        Intent startProgram = new Intent(this, MainProgram.class);

        Fragment fragment = new YourFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();
        //SE TUDO CERTO, INICIA ACTIVITY PRINCIPAL
        startActivity(startProgram);
    }
*/

    public void registerNewUser(View view){
    /*    makeNewUser = new Intent(this, Login.class);


        // Confirmação de que os campos foram preenchidos e não estão nulos
        EditText username = (EditText) findViewById(R.id.newUserName);
        newUserName = username.getText().toString();

        if(TextUtils.isEmpty(newUserName)){
            username.setError("Este campo é obrigatório!");
            return;
        }

        EditText userEmail = (EditText) findViewById(R.id.newUserEmail);
        newUserEmail = userEmail.getText().toString();

        if(TextUtils.isEmpty(newUserEmail)){
            userEmail.setError("Este campo é obrigatório!");
            return;
        }

        EditText userPasswrd = (EditText) findViewById(R.id.newUserPasswrd);
        userPassword = userPasswrd.getText().toString();

        if(TextUtils.isEmpty(userPassword)){
            userPasswrd.setError("Este campo é obrigatório!");
            return;
        }

        EditText userConfirmationPasswrd = (EditText) findViewById(R.id.newUserConfirmPasswrd);
        userConfirmPassword = userConfirmationPasswrd.getText().toString();

        if(TextUtils.isEmpty(userConfirmPassword)){
            userConfirmationPasswrd.setError("Este campo é obrigatório!");
            return;
        }
        /////////////////////////////////////////////////////////////////////


        //Confirmação de que a senha de confirmação é identica a senha fornecida no campo anterior.
        //Se correto, prossegue o processe para confirmação de cadastro. Caso Contrário, notifica
        //que as senhas são diferentes.
        if (userPassword.equals(userConfirmPassword)) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Confirmar todos os campos?");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "CONFIRMAR",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            //GUARDAR TODOS OS DADOS DE ENTRADA DADOS NO BANCO DE DADOS



                            //APÓS RETOMAR AO MENU INICIAL PARA O USUARIO ENTRAR COM SEU EMAIL E SENHA CRIADOS
                            backToLogin();
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
        */
    }


    public void backToLogin(){/*
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Cadastro realizado com sucesso! \nInsira seu email e senha " +
                "informados para ter o acesso ao UFRGS Caronas!");
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(makeNewUser);
                        finish();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
        */
    }

}