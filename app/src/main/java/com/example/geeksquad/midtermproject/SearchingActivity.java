package com.example.geeksquad.midtermproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
    }
    public void onSearchClicked(View view) {
        Intent i = new Intent(getBaseContext(), MapsActivity.class);
        startActivity(i);
    }

}
