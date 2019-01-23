package com.batista.kleyton.starwarsapp.Service;


import com.batista.kleyton.starwarsapp.Resources.PersonagemResultado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlugAPI {

    @GET("people")
    Call<PersonagemResultado> searchPeople(@Query("search") String search);

}
