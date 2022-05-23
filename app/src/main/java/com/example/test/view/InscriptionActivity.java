package com.example.test.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.helper.RetrofitClient;
import com.example.test.controller.SettingController;
import com.example.test.model.Profils;
import com.example.test.model.ProfilsResponses;
import com.example.test.services.UserServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView connexion;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
        this.control = SettingController.getInstance();

    }

    private EditText Mail;
    private EditText Pseudo;
    private EditText MotDePass;
    private SettingController control;

    public void init() {
        this.Mail = (EditText) findViewById(R.id.email);
        this.Pseudo = (EditText) findViewById(R.id.Pseudo);
        this.MotDePass = (EditText) findViewById(R.id.password);
        SharedPreferences sharedPreferences= this.getSharedPreferences("userIdentity", Context.MODE_PRIVATE);
        this.connexion = (TextView) findViewById(R.id.connexion);
        String name = sharedPreferences.getString("token",null);
        if(name !=null){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        this.connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        this.button = (Button)findViewById(R.id.login);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inscription(sharedPreferences);
            }
        });
    }

    private void inscription(SharedPreferences sharedPreferences) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Chargement");
                progressDialog.show();
                Profils profils = new Profils();

                ArrayList<Profils> result = new ArrayList<Profils>();
                try {
                    profils.setPseudo(Pseudo.getText().toString());
                    profils.setPassword(MotDePass.getText().toString());
                    profils.setMail(Mail.getText().toString());
                    UserServices userspace = RetrofitClient.getRetrofitInstance().create(UserServices.class);
                    userspace.Signin(profils).enqueue(
                            new Callback<ProfilsResponses>() {
                                @Override
                                public void onResponse(Call<ProfilsResponses> call, Response<ProfilsResponses> response) {
                                    progressDialog.dismiss(); //dismiss progress dialog
                                    if (response.body() != null) {
                                        System.out.println(response.body().getUser().getPseudo());
                                        doSave(response.body().getAccessToken(), response.body().getUser().getPseudo(),sharedPreferences);
                                        Intent intent = new Intent(MainActivity.this, HomepageActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Login ou mots de passe incorrecte", Toast.LENGTH_LONG).show();
                                        progressDialog.dismiss();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ProfilsResponses> call, Throwable t) {
                                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.println(t);

                                    progressDialog.dismiss();
                                }
                            });
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, " une erreur est survenue", Toast.LENGTH_SHORT).show();
                }
    }
    public void doSave(String token,String login, SharedPreferences sharedPreferences)  {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.putString("login", login);
        editor.apply();
    }
}