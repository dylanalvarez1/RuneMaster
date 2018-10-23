package com.example.geeksquad.midtermproject;

import android.net.Uri;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

public class BattleActivity  extends ClosableActivity {
    boolean battleWon;
    boolean battleLost;
    boolean applyStatus;
    boolean selectSpell;
    boolean selectItem;
    boolean enemyTurn;
    boolean run;
    boolean runDelay;
    TextView turnText;
    TextView playerHealth;
    TextView playerLevel;
    TextView playerMana;
    TextView playerStatus;
    TextView playerName;
    LifeForm enemy;
    TextView enemyHealth;
    TextView enemyName;
    TextView enemyStatus;
    TextView enemyLevel;
    ImageView enemyIcon;
    TextView enemyType;
    Button pButton;
    Button cButton;
    Button iButton;
    Button rButton;
    Button spellButton1;
    Button spellButton2;
    Button spellButton3;
    Button itemButton1;
    Button itemButton2;
    Button itemButton3;

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

                    if(run) {
                        runDelay = true;
                        finish();
                    }

                    //If user attacked then the enemy gets to attack back
                    if(enemyTurn) {
                        if(enemy.health > 0) enemy.randomAttack(MainActivity.player);
                        else enemy.deathEvent();
                        enemyTurn = false;
                        if(MainActivity.player.health <= 0) {
                            battleText.offer(MainActivity.player.name + " was defeated! They lost all their gold.");
                        }
                    }
                    if(applyStatus) {
                        applyStatusEffects(MainActivity.player, enemy);
                        applyStatus = false;
                    }

                }

                else {
                    battleDescription.setText("");
                    turnText.setText("Your move!");
                    enableInputs();
                    if(enemy.health <= 0) {
                        turnText.setText("");
                        disableInputs();
                        if(!battleWon) {
                            battleWon = true;
                            battleDescription.setText("You killed the " + enemy.name + "!");
                            MainActivity.player.clearModifiers();
                            MainActivity.player.levelUp();
                        }
                        else { //Do this so they have a chance to see the level up text
                            finish();
                        }

                    }
                    if(MainActivity.player.health <= 0) {
                        MainActivity.player.death(MainActivity.player);
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
        getSupportActionBar().hide();
        findElements();
        run = false;
        runDelay = false;
        battleWon = false;
        selectSpell = false;
        selectItem = false;
        enemyTurn = true;
        applyStatus = false;
        enemy = EnemyGenerator.newEnemy();
        setStaticFields();
        updateStats();
    }

    void setStaticFields() {
        enemyName.setText(enemy.name);
        enemyLevel.setText("Level: " + Integer.toString(enemy.level));
        playerLevel.setText("Level: " + Integer.toString(MainActivity.player.level));
        enemyType.setText("Type: " + enemy.type);
        enemyIcon.setImageResource(enemy.imageSource);
    }

    void updateStats() { //update health, mana, status of enemy and player
        enemyHealth.setText("Health: " + Integer.toString(enemy.health));
        enemyStatus.setText("Status: " + enemy.status);
        playerHealth.setText("Health: " + Integer.toString(MainActivity.player.health));
        playerMana.setText("Mana: " + Integer.toString(MainActivity.player.mana));
        playerStatus.setText("Status: " + MainActivity.player.status);
        itemButton1.setText("Health Potions: " + MainActivity.player.healthPotions.size());
        itemButton2.setText("Mana Potions: " + MainActivity.player.manaPotions.size());
        itemButton3.setText("Mysterious Runes: " + MainActivity.player.mysteriousRunes.size());

        if(MainActivity.player.healthPotions.size() <= 0) {
            itemButton1.setEnabled(false);
        }
        else {
            itemButton1.setEnabled(true);
        }
        if(MainActivity.player.manaPotions.size() <= 0) {
            itemButton2.setEnabled(false);
        }
        else {
            itemButton2.setEnabled(true);
        }
        if(MainActivity.player.mysteriousRunes.size() <= 0) {
            itemButton3.setEnabled(false);
        }
        else {
            itemButton3.setEnabled(true);
        }

        if(MainActivity.player.mana - MainActivity.player.getSpell(0).cost < 0) {
            spellButton1.setEnabled(false);
        }
        else {
            spellButton1.setEnabled(true);
        }
        if(MainActivity.player.mana - MainActivity.player.getSpell(1).cost < 0) {
            spellButton2.setEnabled(false);
        }
        else {
            spellButton2.setEnabled(true);
        }
        if(MainActivity.player.mana - MainActivity.player.getSpell(2).cost < 0) {
            spellButton3.setEnabled(false);
        }
        else {
            spellButton3.setEnabled(true);
        }


    }

    public void onBasicAttack(View view) {
        turnText.setText("");
        enemyTurn = true;
        applyStatus = true;
        MainActivity.player.basicAttack(enemy);
        disableInputs();

    }
    public void onSpellAttack(View view) {
        hideMenu();
        updateStats();
        selectSpell = true;

    }
    public void onItem(View view) {
        hideMenuItemVersion();
        updateStats();
        selectItem = true;
    }

    public void onRunAway(View view) {
        battleText.offer("You run away as fast as you can dropping gold in the process.");
        run = true;
    }

    public void onItem1(View view) {
        MainActivity.player.useItem("Health Potion", MainActivity.player, enemy);
        updateStats();
    }

    public void onItem2(View view) {
        MainActivity.player.useItem("Mana Potion", MainActivity.player, enemy);
        updateStats();
    }

    public void onItem3(View view) {
        MainActivity.player.useItem("Mysterious Rune", MainActivity.player, enemy);
        updateStats();
    }

    public void onSpellCast1(View view) {
        if(MainActivity.player.mana - MainActivity.player.getSpell(0).cost >= 0)
        {
            MainActivity.player.mana -= MainActivity.player.getSpell(0).cost;
            turnText.setText("");
            enemyTurn = true;
            applyStatus = true;
            MainActivity.player.castSpell(enemy, MainActivity.player.getSpell(0));
            revertMenu();
            disableInputs();
        }

    }

    public void onSpellCast2(View view) {
        if(MainActivity.player.mana - MainActivity.player.getSpell(1).cost >= 0)
        {
            MainActivity.player.mana -= MainActivity.player.getSpell(1).cost;
            turnText.setText("");
            enemyTurn = true;
            applyStatus = true;
            MainActivity.player.castSpell(enemy, MainActivity.player.getSpell(1));
            revertMenu();
            disableInputs();
        }

    }
    public void onSpellCast3(View view) {
        if(MainActivity.player.mana - MainActivity.player.getSpell(2).cost >= 0)
        {
            MainActivity.player.mana -= MainActivity.player.getSpell(2).cost;
            turnText.setText("");
            enemyTurn = true;
            applyStatus = true;
            MainActivity.player.castSpell(enemy, MainActivity.player.getSpell(2));
            revertMenu();
            disableInputs();
        }

    }

    void findElements() {
        turnText = findViewById(R.id.turnText);
        playerHealth = findViewById(R.id.playerHealth);
        playerLevel = findViewById(R.id.playerLevel);
        playerMana = findViewById(R.id.playerMana);
        playerStatus = findViewById(R.id.playerStatus);
        //playerName = findViewById(R.id.playerName);
        enemyHealth = findViewById(R.id.enemyHealth);
        enemyLevel = findViewById(R.id.enemyLevel);
        enemyStatus = findViewById(R.id.enemyStatus);
        enemyName = findViewById(R.id.enemyName);
        enemyType = findViewById(R.id.enemyType);
        enemyIcon = findViewById(R.id.enemyIcon);
        battleDescription = findViewById(R.id.battleDescription);
        pButton = findViewById(R.id.pButton);
        cButton = findViewById(R.id.cButton);
        iButton = findViewById(R.id.iButton);
        rButton = findViewById(R.id.rButton);
        spellButton1 = findViewById(R.id.spellButton1);
        spellButton2 = findViewById(R.id.spellButton2);
        spellButton3 = findViewById(R.id.spellButton3);
        itemButton1 = findViewById(R.id.itemButton1);
        itemButton2 = findViewById(R.id.itemButton2);
        itemButton3 = findViewById(R.id.itemButton3);

        spellButton1.setText(MainActivity.player.getSpell(0).name);
        spellButton2.setText(MainActivity.player.getSpell(1).name);
        spellButton3.setText(MainActivity.player.getSpell(2).name);
        itemButton1.setText("Health Potions: " + MainActivity.player.healthPotions.size());
        itemButton2.setText("Mana Potions: " + MainActivity.player.manaPotions.size());
        itemButton3.setText("Mysterious Runes: " + MainActivity.player.mysteriousRunes.size());
    }

    void enableInputs() {
        pButton.setEnabled(true);
        cButton.setEnabled(true);
        iButton.setEnabled(true);
        rButton.setEnabled(true);
        /*
        itemButton1.setEnabled(true);
        itemButton2.setEnabled(true);
        itemButton3.setEnabled(true);
        */
    }
    void disableInputs() {
        pButton.setEnabled(false);
        cButton.setEnabled(false);
        iButton.setEnabled(false);
        rButton.setEnabled(false);
        itemButton1.setEnabled(false);
        itemButton2.setEnabled(false);
        itemButton3.setEnabled(false);
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

    void hideMenuItemVersion() {
        pButton.setVisibility(View.INVISIBLE);
        cButton.setVisibility(View.INVISIBLE);
        rButton.setVisibility(View.INVISIBLE);
        iButton.setVisibility(View.INVISIBLE);

        itemButton1.setVisibility(View.VISIBLE);
        itemButton2.setVisibility(View.VISIBLE);
        itemButton3.setVisibility(View.VISIBLE);
    }
    void revertMenu() {
        pButton.setVisibility(View.VISIBLE);
        cButton.setVisibility(View.VISIBLE);
        rButton.setVisibility(View.VISIBLE);
        iButton.setVisibility(View.VISIBLE);

        spellButton1.setVisibility(View.INVISIBLE);
        spellButton2.setVisibility(View.INVISIBLE);
        spellButton3.setVisibility(View.INVISIBLE);

        itemButton1.setVisibility(View.INVISIBLE);
        itemButton2.setVisibility(View.INVISIBLE);
        itemButton3.setVisibility(View.INVISIBLE);
    }

    public void applyStatusEffects(LifeForm player, LifeForm enemy) {
        if(player.status == "burned") {
            player.health -= 10;
            if(player.health < 0) player.health = 0;
            battleText.offer(player.name + " took damage from burns!");
        }
        if(enemy.status == "burned") {
            enemy.health -= 10;
            if(enemy.health < 0) enemy.health = 0;
            battleText.offer(enemy.name + " took damage from burns!");
        }
        if(player.status == "frozen") {
            player.physicalMod = 1;
            player.accuracyMod = 1;
            player.defenseMod = 1;
            player.spellMod = 1;
            battleText.offer(player.name + " lost all buffs from being frozen!");
        }
        if(enemy.status == "frozen") {
            enemy.physicalMod = 1;
            enemy.accuracyMod = 1;
            enemy.defenseMod = 1;
            enemy.spellMod = 1;
            battleText.offer(enemy.name + " lost all buffs from being frozen!");
        }
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
        //TODO: Only allow the closure of the intent once you win the battle
        /*
        if (battleWon) {
            super.onBackPressed();
        }
        */
        if(selectSpell) {
            revertMenu();
        }
        if(selectItem) {
            revertMenu();
        }
    }

}
