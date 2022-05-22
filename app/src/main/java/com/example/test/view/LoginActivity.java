package com.example.test.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.controls.Control;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.Utils.RetrofitClient;
import com.example.test.controller.SettingController;
import com.example.test.model.Login;
import com.example.test.model.Profils;
import com.example.test.model.ProfilsResponses;
import com.example.test.services.UserServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private TextView inscription;
    private EditText Pseudo;
    private EditText MotDePass;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.init();

    }

    public void init(){
        this.inscription = (TextView)findViewById(R.id.connexion);
        this.Pseudo = (EditText) findViewById(R.id.Pseudo);
        this.MotDePass = (EditText) findViewById(R.id.password);
        login();
        this.inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        this.button = (Button)findViewById(R.id.login);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login (){
        ((Button) findViewById(R.id.login)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Chargement");
                progressDialog.show();
                Profils profils = new Profils();

                ArrayList<Profils> result = new ArrayList<Profils>();
                try {
                    profils.setPseudo(Pseudo.getText().toString());
                    profils.setPassword(MotDePass.getText().toString());
                    UserServices userspace = RetrofitClient.getRetrofitInstance().create(UserServices.class);

                    userspace.login(profils).enqueue(
                            new Callback<ProfilsResponses>() {
                                @Override
                                public void onResponse(Call<ProfilsResponses> call, Response<ProfilsResponses> response) {
                                    progressDialog.dismiss(); //dismiss progress dialog
                                    if (response.body() != null) {
                                        System.out.println(response.body() );
                                        result.add (response.body().getUser());
                                        doSave(response.body().getAccessToken(), result.get(0).getPseudo());
                                        Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Login ou mots de passe incorrecte", Toast.LENGTH_LONG).show();
                                        progressDialog.dismiss();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ProfilsResponses> call, Throwable t) {
                                    Toast.makeText(LoginActivity.this , t.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.println(t );

                                    progressDialog.dismiss();
                                }
                            });
                }
                catch (Exception e){
                    Toast.makeText(LoginActivity.this , " une erreur est survenue" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * verification des editText
     */
    private boolean validate(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        }
        editText.setError("Champs obligatoire");
        editText.requestFocus();
        return false;
    }

    public void doSave(String token,String login)  {
        SharedPreferences sharedPreferences= this.getSharedPreferences("userIdentity", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.putString("login", login);
        editor.apply();
    }
}
