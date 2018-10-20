package com.example.geeksquad.midtermproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ClosableActivity {
   public static Player player;
   Spell fireball;
   Spell frostbolt;
   Spell lightning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        getSupportActionBar().hide();

        player = new Player("Player",100, 150, 1,100, 50, 250, "None", "Human", 0);
        fireball = new Spell("Fireball", "fire", 1, "burned");
        frostbolt = new Spell("Frostbolt", "ice", 1, "freezed");
        lightning = new Spell("Lightning", "electric", 1, "shocked");

        player.setSpell(fireball, 0);
        player.setSpell(frostbolt, 1);
        player.setSpell(lightning, 2);
    }
    public void onSearchClicked(View view) {
        Intent i = new Intent(getBaseContext(), MapsActivity.class);
        startActivity(i);
    }
    public void onBattleClicked(View view) {
        Intent i = new Intent(getBaseContext(), BattleActivity.class);
        startActivity(i);
    }
    public void onAboutClicked(View view) {
        Intent i = new Intent(getBaseContext(), AboutActivity.class);
        startActivity(i);
    }

}
