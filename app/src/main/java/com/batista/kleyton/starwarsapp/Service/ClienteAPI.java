package com.batista.kleyton.starwarsapp.Service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteAPI {

    private static PlugAPI REST_CLIENT;
    private static final String API_URL = "http://swapi.co/api/";

    static {

        setupRestClient();
    }

    private ClienteAPI() {
    }

    public static PlugAPI get() {
        return REST_CLIENT;
    }


    private static void setupRestClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        REST_CLIENT = retrofit.create(PlugAPI.class);
    }

}