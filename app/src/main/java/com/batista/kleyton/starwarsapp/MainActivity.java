package com.batista.kleyton.starwarsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.batista.kleyton.starwarsapp.Usuario.CadastrarActivity;
import com.batista.kleyton.starwarsapp.Usuario.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

    }

    public void login(View view) {

        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, StarWarsActivity.class);
            startActivity(intent);
        }

    }

    public void cadastrar(View view) {
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }
}