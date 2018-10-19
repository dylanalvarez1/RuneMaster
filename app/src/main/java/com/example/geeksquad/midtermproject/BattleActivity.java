package com.example.geeksquad.midtermproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class BattleActivity  extends ClosableActivity {
    LifeForm enemy;
    TextView enemyHealth;
    TextView enemyName;
    public static Queue<String> battleText = new LinkedList<String>();
    TextView battleDescription;
    int i = 0;
    Handler h = new Handler();
    int delay = 2*1000; //1 second=1000 milisecond
    Runnable runnable;

    @Override
    protected void onResume() {
        //start handler as activity become visible

        h.postDelayed( runnable = new Runnable() {
            public void run() {
                //update battle description if the queue has text to go through
                if(battleText.peek() != null)
                    battleDescription.setText(battleText.poll());
                else battleDescription.setText(" ");

                //battleDescription.setText(Integer.toString(i++));
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
        enemy = new LifeForm("Elder Dragon", 60, 30, 2,10, 1, "None", "ice");
        enemyHealth = findViewById(R.id.enemyHealth);
        enemyName = findViewById(R.id.enemyName);
        battleDescription = findViewById(R.id.battleDescription);
        enemyHealth.setText("Health: " + enemy.health);
        enemyName.setText(enemy.name);

    }
    public void onBasicAttack(View view) {
        enemyHealth = findViewById(R.id.enemyHealth);
        SearchingActivity.player.basicAttack(enemy);
        String update = "Health: " + Integer.toString(enemy.health);
        battleText.offer("The player walked up and hit the dragon!");

        enemyHealth.setText(update);

    }
    public void onSpellAttack(View view) {

    }
    public void onItem(View view) {

    }
    public void onRunAway(View view) {

    }


}
