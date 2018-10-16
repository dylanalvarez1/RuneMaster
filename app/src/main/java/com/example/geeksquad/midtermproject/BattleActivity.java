package com.example.geeksquad.midtermproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BattleActivity  extends ClosableActivity {
    LifeForm enemy;
    TextView enemyHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        enemy = new LifeForm(60, 30, 2,10, 1, "None", "ice");
        enemyHealth = findViewById(R.id.enemyHealth);
        enemyHealth.setText("Health: " + enemy.health);
    }
    public void onBasicAttack(View view) {
        SearchingActivity.player.basicAttack(enemy);
        enemyHealth.setText("Health: "+enemy.health);

    }
    public void onSpellAttack(View view) {

    }
    public void onItem(View view) {

    }
    public void onRunAway(View view) {

    }


}
