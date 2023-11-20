package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.retrofitapp.retrofitmovieapi.API;
import com.example.retrofitapp.retrofitmovieapi.ApiClient;
import com.example.retrofitapp.retrofitmovieapi.ListAdapter;
import com.example.retrofitapp.retrofitmovieapi.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListAdapter adapter;

    String API_KEY = "0f1e592457dd23e83af3c189592456bc";

    String LANGUAGE = "en-US";

    String CATEGORY = "popular";

    int PAGE = 1;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMovie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CallRetrofit();
    }

    private void CallRetrofit(){
        API APIinterface = ApiClient.getClient().create(API.class);

        Call<Movie> caller = APIinterface.getMovie(CATEGORY, API_KEY, LANGUAGE, PAGE);

        caller.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                List<Movie> mList = response.body().getResults();
                adapter = new ListAdapter(MainActivity.this, mList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.fillInStackTrace();
            }
        });
    }

}