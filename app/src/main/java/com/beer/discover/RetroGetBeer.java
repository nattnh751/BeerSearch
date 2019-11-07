package com.beer.discover;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

interface RetroGetBeer {
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("beers")
    Call<ArrayList<Beer>> getBeer(@Query("beer_name") String name);
}
