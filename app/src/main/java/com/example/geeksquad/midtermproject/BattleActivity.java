package com.example.geeksquad.midtermproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class BattleActivity  extends ClosableActivity {
    boolean battleWon;
    boolean battleLost;
    boolean selectSpell;
    TextView turnText;
    TextView playerHealth;
    TextView playerDef;
    TextView playerMana;
    LifeForm enemy;
    TextView enemyHealth;
    TextView enemyName;
    Button pButton;
    Button cButton;
    Button iButton;
    Button rButton;
    Button spellButton1;
    Button spellButton2;
    Button spellButton3;

    public static Queue<String> battleText = new LinkedList<String>();

    TextView battleDescription;
    Handler h = new Handler();
    int delay = 2*1000; //1 second=1000 milisecond
    Runnable runnable;

    @Override
    protected void onResume() {
        //start handler as activity become visible

        h.postDelayed( runnable = new Runnable() {
            public void run() {
                //This is the event queue: If the player does something, then the battle text has something in it, meaning after you update the battle text,
                //We need to allow the enemy to fight back, we need to disable input(and eventually enable) as well.

                updateStats();
                if(battleText.peek() != null) {
                    //update battle description if the queue has text to go through
                    battleDescription.setText(battleText.poll());

                }

                else {
                    battleDescription.setText("");
                    turnText.setText("Your Move!");
                    enableInputs();
                    if(enemy.health <= 0) {
                        battleWon = true;
                        finish();
                    }
                }


                h.postDelayed(runnable, delay);
            }
        }, delay);

        super.onResume();
    }

    @Override
    protected void onPause() {
        h.removeCallbacks(runnable); //stop handler when activity not visible
        super.onPause();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        findElements();
        battleWon = false;
        selectSpell = false;
        enemy = new LifeForm("Elder Dragon", 60, 30, 2,10, 1, "None", "ice");
        enemyName.setText(enemy.name);
        updateStats();
    }

    public void updateStats() { //update health, mana, status of enemy and player
        enemyHealth.setText("Health: " + Integer.toString(enemy.health));
        playerHealth.setText("Health" + Integer.toString(SearchingActivity.player.health));
        playerMana.setText("Mana: " + Integer.toString(SearchingActivity.player.mana));

    }

    public void onBasicAttack(View view) {
        turnText.setText("");
        SearchingActivity.player.basicAttack(enemy);
        String update = "Health: " + Integer.toString(enemy.health);
        battleText.offer("The player walked up and hit the dragon!");

        disableInputs();

        //enemyHealth.setText(update);

    }
    public void onSpellAttack(View view) {
        hideMenu();
        selectSpell = true;

    }
    public void onItem(View view) {

    }
    public void onRunAway(View view) {
        battleText.offer("You run away as fast as you can dropping gold in the process.");
        finish();
    }

    public void onSpellCast1(View view) {
        turnText.setText("");
        SearchingActivity.player.castSpell(enemy, SearchingActivity.player.getSpell(0));
        revertMenu();
    }

    public void onSpellCast2(View view) {
        turnText.setText("");
        SearchingActivity.player.castSpell(enemy, SearchingActivity.player.getSpell(1));
        revertMenu();
    }
    public void onSpellCast3(View view) {
        turnText.setText("");
        SearchingActivity.player.castSpell(enemy, SearchingActivity.player.getSpell(2));
        revertMenu();
    }

    void findElements() {
        turnText = findViewById(R.id.turnText);
        playerHealth = findViewById(R.id.playerHealth);
        playerDef = findViewById(R.id.playerDefense);
        playerMana = findViewById(R.id.playerMana);
        enemyHealth = findViewById(R.id.enemyHealth);
        enemyName = findViewById(R.id.enemyName);
        battleDescription = findViewById(R.id.battleDescription);
        pButton = findViewById(R.id.pButton);
        cButton = findViewById(R.id.cButton);
        iButton = findViewById(R.id.iButton);
        rButton = findViewById(R.id.rButton);
        spellButton1 = findViewById(R.id.spellButton1);
        spellButton2 = findViewById(R.id.spellButton2);
        spellButton3 = findViewById(R.id.spellButton3);
        spellButton1.setText(SearchingActivity.player.getSpell(0).name);
        spellButton2.setText(SearchingActivity.player.getSpell(1).name);
        spellButton3.setText(SearchingActivity.player.getSpell(2).name);
    }

    void enableInputs() {
        pButton.setEnabled(true);
        cButton.setEnabled(true);
        iButton.setEnabled(true);
        rButton.setEnabled(true);
    }
    void disableInputs() {
        pButton.setEnabled(false);
        cButton.setEnabled(false);
        iButton.setEnabled(false);
        rButton.setEnabled(false);
    }
    void hideMenu() {
        pButton.setVisibility(View.INVISIBLE);
        cButton.setVisibility(View.INVISIBLE);
        rButton.setVisibility(View.INVISIBLE);
        iButton.setVisibility(View.INVISIBLE);

        spellButton1.setVisibility(View.VISIBLE);
        spellButton2.setVisibility(View.VISIBLE);
        spellButton3.setVisibility(View.VISIBLE);
    }
    void revertMenu() {
        pButton.setVisibility(View.VISIBLE);
        cButton.setVisibility(View.VISIBLE);
        rButton.setVisibility(View.VISIBLE);
        iButton.setVisibility(View.VISIBLE);

        spellButton1.setVisibility(View.INVISIBLE);
        spellButton2.setVisibility(View.INVISIBLE);
        spellButton3.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
        //TODO: Only allow the closure of the intent once you win the battle
        if (battleWon) {
            super.onBackPressed();
        }
        if(selectSpell) {
            revertMenu();
        }
    }

}
