package com.beer.discover;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiHelper {
    private static Retrofit retrofit;

    public static void searchForBeerWithName(BeerSearchActivity beerSearchActivity, final SearchResultsCallBack callback, String query) {
        RetroGetBeer service = getBaseRetrofitInstance().create(RetroGetBeer.class);
        Call<ArrayList<Beer>> response = service.getBeer(query);
        response.enqueue(new Callback<ArrayList<Beer>>() {
            @Override
            public void onResponse(Call<ArrayList<Beer>> call, Response<ArrayList<Beer>> response) {
                final GetBeerResponse finalRes = new GetBeerResponse();
                finalRes.beers = response.body();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        callback.GetBeerComplete(finalRes);
                    }
                }).start();
            }
            @Override
            public void onFailure(Call<ArrayList<Beer>> call, Throwable t) {
                final GetBeerResponse finalRes = new GetBeerResponse();
                callback.GetBeerComplete(null);
            }
        });
    }

    public static Retrofit getBaseRetrofitInstance() {
        String UA = System.getProperty("http.agent");  // Get android user agent.
        OkHttpClient okHttp = new OkHttpClient().newBuilder().build();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://api.punkapi.com/v2/")
                    .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttp)
                    .build();
        }
        return retrofit;
    }
}
