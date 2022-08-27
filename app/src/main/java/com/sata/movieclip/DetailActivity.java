package com.sata.movieclip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.sata.movieclip.Model.MovieByIdModel;
import com.sata.movieclip.Retrofit.ApiService;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    TextView tvJudul, tvtahunRelease, tvdeskripsiDetail, tvTanggal;
    ImageView imgDetailPoster;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul=findViewById(R.id.judulFilem);
        tvtahunRelease= findViewById(R.id.tahunRelease);
        tvdeskripsiDetail = findViewById(R.id.deskripsiDetail);
        tvTanggal = findViewById(R.id.Tanggal);
        imgDetailPoster = findViewById(R.id.imgDetailPoster);


        //ambil kiriman dari list intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        id = intent.getStringExtra("imdbID");

        Log.i("CEK Id",id);
        onRequestData();

        //memuat konten
        tvJudul.setText(title);
    }

    private void onRequestData() {
        Map<String, String> params = new HashMap<>();
        params.put("apikey", "b45dad4f");
        params.put("i", id);

        ApiService.endpoint().getDetail(params).enqueue(new Callback<MovieByIdModel>() {
            @Override
            public void onResponse(Call<MovieByIdModel> call, Response<MovieByIdModel> response) {
                tvtahunRelease.setText("Tahun : "+response.body().getYear());
                tvdeskripsiDetail.setText(response.body().getPlot());
                tvTanggal.setText("Release :"+response.body().getReleased());
                Picasso.get().load(response.body().getPoster()).into(imgDetailPoster);
            }

            @Override
            public void onFailure(Call<MovieByIdModel> call, Throwable t) {
                Log.d("TES GAGAL", t.toString());
            }
        });
    }
}