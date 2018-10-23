package com.example.geeksquad.midtermproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ItemActivity extends AppCompatActivity{

    TextView itemTitle;
    TextView itemDescription;
    ImageView itemIcon;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_item);
        //Set image of item

        //Set description of item
        itemTitle = findViewById(R.id.itemTitle);
        itemDescription = findViewById(R.id.itemDescription);
        itemIcon = findViewById(R.id.itemIcon);

        Item healthPot = new Item("Health Potion");
        Item manaPot = new Item("Mana Potion");
        Item rune = new Item("Mysterious Rune");

        int random = getRandomNumberInRange(0,2);
        switch(random) {
            case 0:
                itemTitle.setText("You found a health potion!");
                itemDescription.setText("Use this in battle to regain your health.");
                itemIcon.setImageResource( R.drawable.flask);
                MainActivity.player.healthPotions.add(healthPot);
                break;
            case 1:
                itemTitle.setText("You found a mana potion!");
                itemDescription.setText("Use this in battle to regain your mana.");
                itemIcon.setImageResource( R.drawable.education);
                MainActivity.player.manaPotions.add(manaPot);
                break;
            case 2:
                itemTitle.setText("You found a mysterious rune!");
                itemDescription.setText("Use this in battle to cast a random spell.");
                itemIcon.setImageResource( R.drawable.book);
                MainActivity.player.mysteriousRunes.add(rune);
                break;
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public void onBackPressed() {
        finish();
    }
}
