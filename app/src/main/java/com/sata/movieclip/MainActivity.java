package com.sata.movieclip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_profile:
                //function untuk pindah ke halaman profile
                Intent intent = new Intent(this,ProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_logout:
                //buatkan action untuk masuk kehalaman login
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}