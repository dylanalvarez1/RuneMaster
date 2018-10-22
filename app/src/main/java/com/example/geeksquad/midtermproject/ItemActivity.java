package com.example.geeksquad.midtermproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItemActivity  extends ClosableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_item);

    }
}
