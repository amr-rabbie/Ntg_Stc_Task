package com.amrrabbie.mvpmarvelltask.services;

import com.amrrabbie.mvpmarvelltask.model.Marvell;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvellInterface {


    @GET("characters")
    public Call<Marvell> getAllMovies(
            @Query("ts") String ts ,
            @Query("apikey") String apikey,
            @Query("hash") String hash
    );


}
