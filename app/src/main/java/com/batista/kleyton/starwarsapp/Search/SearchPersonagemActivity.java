package com.batista.kleyton.starwarsapp.Search;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.batista.kleyton.starwarsapp.MainActivity;
import com.batista.kleyton.starwarsapp.R;
import com.batista.kleyton.starwarsapp.Resources.Personagem;
import com.batista.kleyton.starwarsapp.Resources.PersonagemResultado;
import com.batista.kleyton.starwarsapp.Service.ClienteAPI;
import com.batista.kleyton.starwarsapp.Service.PlugAPI;
import com.batista.kleyton.starwarsapp.StarWarsActivity;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPersonagemActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    EditText edSearch;
    TextView txtResult;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("People");
        setContentView(R.layout.activity_search_personagem);

        auth = FirebaseAuth.getInstance();

        edSearch = (EditText) findViewById(R.id.edSearch);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnSearch = (Button) findViewById(R.id.btnSearch);

    }


    public void btnSearch_onClick(View view) {

        searchPeople(edSearch.getText().toString());
    }

    private void searchPeople(final String tagword) {

        Call<PersonagemResultado> call = ClienteAPI.get().searchPeople(tagword);

        call.enqueue(new Callback<PersonagemResultado>() {
            @Override
            public void onResponse(Call<PersonagemResultado> call, Response<PersonagemResultado> response) {

                Log.d("PlugAPI", "Resposta com sucesso obtida");
                edSearch.setText("");
                PersonagemResultado personagem = response.body();

                if (personagem.results.size() > 0)
                    txtResult.setText(personagem.results.get(0).toString());
                else
                    txtResult.setText("Seu pedido não foi encontrado!");
            }

            @Override
            public void onFailure(Call<PersonagemResultado> call, Throwable t) {

                txtResult.setText("Ocorreu um erro " + t.toString());
                edSearch.setText("");

            }
        });
    }

    public void logout(View view) {

        Intent i = new Intent(SearchPersonagemActivity.this, MainActivity.class);
        startActivity(i);

        auth.signOut();
        finish();

    }

}
