package com.batista.kleyton.starwarsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.batista.kleyton.starwarsapp.Search.SearchPersonagemActivity;

public class StarWarsActivity extends AppCompatActivity {

    Button btnPeople;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);

        btnPeople = (Button) findViewById(R.id.btnPeople);


    }

    public void btnPeople_onClick(View view) {
        Intent i = new Intent(StarWarsActivity.this, SearchPersonagemActivity.class);
        startActivity(i);
    }


}
