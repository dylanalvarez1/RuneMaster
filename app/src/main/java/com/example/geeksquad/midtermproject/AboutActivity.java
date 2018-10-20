package com.example.geeksquad.midtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity  extends ClosableActivity {
    TextView playerHealth;
    TextView playerLevel;
    TextView playerMana;
    TextView playerStatus;
    TextView playerExp;
    TextView playerGold;
    Button recoverButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();
        findElements();
        updateStats();
    }

    public void onSetSpells(View view) {
        Intent i = new Intent(getBaseContext(), SetSpellActivity.class);
        startActivity(i);
    }

    public void onRecoverAtIn(View view) {
        if(MainActivity.player.gold - 250 >= 0) {
            MainActivity.player.gold -= 250;
            MainActivity.player.health = MainActivity.player.maxHealth;
            MainActivity.player.mana = MainActivity.player.maxMana;
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
        recoverButton = findViewById(R.id.recoverButton);
    }

    void updateStats() { //update health, mana, status of enemy and player
        playerHealth.setText("Health: " + Integer.toString(MainActivity.player.health) + " / " + Integer.toString(MainActivity.player.maxHealth));
        playerMana.setText("Mana: " + Integer.toString(MainActivity.player.mana) + " / " + Integer.toString(MainActivity.player.maxMana));
        playerStatus.setText("Status: " + MainActivity.player.status);
        playerLevel.setText("Level: " + MainActivity.player.level);
        playerGold.setText("Gold: " + MainActivity.player.gold);
        playerExp.setText("Exp: " + MainActivity.player.exp);
        if(MainActivity.player.gold < 250) recoverButton.setEnabled(false);
        else recoverButton.setEnabled(true);
    }
}
