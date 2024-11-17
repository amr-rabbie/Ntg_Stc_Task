package com.amrrabbie.mvpmarvelltask.ui;

import android.util.Log;
import android.widget.Toast;

import com.amrrabbie.mvpmarvelltask.basics.BasicUrl;
import com.amrrabbie.mvpmarvelltask.basics.RetrofitBase;
import com.amrrabbie.mvpmarvelltask.model.Data;
import com.amrrabbie.mvpmarvelltask.model.Marvell;
import com.amrrabbie.mvpmarvelltask.model.Result;
import com.amrrabbie.mvpmarvelltask.services.MarvellInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelPresenter {
    MarvelView marvelView;
    List<Result> results;

    public MarvelPresenter(MarvelView marvelView) {
        this.marvelView = marvelView;
    }


    private void getMoviesFromDbOnline(){

        String ts="1";
        String apikey="ff99b2451d5cd421f8e1d63b593e50d6";
        String hash="47b2c7d86a52d3663db5c0e996d4a887";

        Retrofit retrofit = RetrofitBase.defineRetrofit();

        MarvellInterface marvellInterface = retrofit.create(MarvellInterface.class);

        Call<Marvell> allMovies = marvellInterface.getAllMovies(ts, apikey, hash);

        allMovies.enqueue(new Callback<Marvell>() {
            @Override
            public void onResponse(Call<Marvell> call, Response<Marvell> response) {
                Marvell marvell = response.body();
                Data data = marvell.getData();
                results = data.getResults();
            }

            @Override
            public void onFailure(Call<Marvell> call, Throwable t) {
                Log.e("network_error",t.getMessage().toString());
            }
        });



    }

    public void getAllMovies(){
        marvelView.getMovies(results);
    }
}
