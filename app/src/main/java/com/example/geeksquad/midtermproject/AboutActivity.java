package com.example.geeksquad.midtermproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutActivity  extends ClosableActivity {
    TextView playerHealth;
    TextView playerLevel;
    TextView playerMana;
    TextView playerStatus;
    TextView playerExp;
    TextView playerGold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        findElements();
        updateStats();
    }

    public void onSetSpells(View view) {
        Intent i = new Intent(getBaseContext(), SetSpellActivity.class);
        startActivity(i);
    }

    public void onRecoverAtIn(View view) {
        if(SearchingActivity.player.gold - 250 >= 0) {
            SearchingActivity.player.gold -= 250;
            SearchingActivity.player.health = SearchingActivity.player.maxHealth;
            SearchingActivity.player.mana = SearchingActivity.player.maxMana;
            updateStats();
        }
    }

    void findElements() {
        playerHealth = findViewById(R.id.playerHealth);
        playerLevel = findViewById(R.id.playerLevel);
        playerMana = findViewById(R.id.playerMana);
        playerStatus = findViewById(R.id.playerStatus);
        playerExp = findViewById(R.id.playerExp);
        playerGold = findViewById(R.id.playerGold);
    }

    void updateStats() { //update health, mana, status of enemy and player
        playerHealth.setText("Health: " + Integer.toString(SearchingActivity.player.health) + " / " + Integer.toString(SearchingActivity.player.maxHealth));
        playerMana.setText("Mana: " + Integer.toString(SearchingActivity.player.mana) + " / " + Integer.toString(SearchingActivity.player.maxMana));
        playerStatus.setText("Status: " + SearchingActivity.player.status);
        playerLevel.setText("Level: " + SearchingActivity.player.level);
        playerGold.setText("Gold: " + SearchingActivity.player.gold);
        playerExp.setText("Exp: " + SearchingActivity.player.exp);
    }
}
