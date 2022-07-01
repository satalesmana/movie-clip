package com.sata.movieclip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
    private ProgressDialog mProgres;

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

        mProgres = new ProgressDialog(this);
        mProgres.setTitle("Loading");
        mProgres.setMessage("Sedang mengambil data...");
        mProgres.show();

        ApiService.endpoint().getData(params).enqueue(new Callback<MovieListModel>() {
            @Override
            public void onResponse(Call<MovieListModel> call, Response<MovieListModel> response) {
                List<MovieListModel.Search> searches = response.body().getSearch();


                movieListAdapter = new MovieListAdapter(MainActivity.this,searches );
                recyclerView.setAdapter(movieListAdapter);

                mProgres.dismiss();
            }

            @Override
            public void onFailure(Call<MovieListModel> call, Throwable t) {
                Log.d("TES GAGAL", t.toString());
                String pesan =  t.toString() + "\n \nKlik OK untuk memuat ulang data...";
                mProgres.dismiss();

                AlertDialog.Builder builder =  new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Infro");
                builder.setMessage(pesan)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                onLoadMovieData();
                            }
                        });
                builder.show();
            }
        });

    }
}