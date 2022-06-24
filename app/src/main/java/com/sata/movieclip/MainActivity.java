package com.sata.movieclip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.sata.movieclip.Adapter.MovieListAdapter;
import com.sata.movieclip.Model.MovieListModel;
import com.sata.movieclip.Retrofit.ApiService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieListAdapter movieListAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recle_movie_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        onLoadMovieData();
    }

    private void onLoadMovieData(){
        String keyword =  "ironman";
        Map<String, String> params = new HashMap<>();
        params.put("apikey","b45dad4f");
        params.put("s", keyword);

        ApiService.endpoint().getData(params).enqueue(new Callback<MovieListModel>() {
            @Override
            public void onResponse(Call<MovieListModel> call, Response<MovieListModel> response) {
                List<MovieListModel.Search> searches = response.body().getSearch();


                movieListAdapter = new MovieListAdapter(MainActivity.this,searches );
                recyclerView.setAdapter(movieListAdapter);
            }

            @Override
            public void onFailure(Call<MovieListModel> call, Throwable t) {
                Log.d("TES GAGAL", t.toString());
            }
        });

    }
}