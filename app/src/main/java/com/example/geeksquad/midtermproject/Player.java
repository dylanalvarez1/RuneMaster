package com.example.geeksquad.midtermproject;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends LifeForm{

    public int  maxMana, gold;
    public int exp = 0;
    public String type;

    //Technically I could have an array of just items, but this is better as I don't plan on having a lot of items to implement
    public ArrayList<Item> healthPotions = new ArrayList<>();
    public ArrayList<Item> manaPotions = new ArrayList<>();
    public ArrayList<Item> mysteriousRunes = new ArrayList<>();

    Player(String name, int health, int mana, int level, int damage, int def, int gold, String status, String type, int imageSource) {
        super(name, health, mana, level, def, status, type, imageSource);
        this.maxMana = mana;
        this.gold = gold;
    }

    public void addItem(Item item) {
        switch(item.name) {
            case "Health Potion":
                healthPotions.add(item);
                break;
            case "Mana Potion":
                manaPotions.add(item);
                break;
            case "Mysterious Rune":
                mysteriousRunes.add(item);
                break;
        }
    }

    public void useItem(String item, Player user, LifeForm target) {

        switch(item) {
            case "Health Potion":
                if(healthPotions.size() > 0)
                {
                    healthPotions.get(healthPotions.size() - 1).use(user, target, item);
                    healthPotions.remove(healthPotions.size() - 1);
                }
                break;
            case "Mana Potion":
                if(manaPotions.size() > 0)
                {
                    manaPotions.get(manaPotions.size() - 1).use(user, target, item);
                    manaPotions.remove(manaPotions.size() - 1);
                }
                break;

            case "Mysterious Rune":
                if(mysteriousRunes.size() > 0)
                {
                    mysteriousRunes.get(mysteriousRunes.size() - 1).use(user, target, item);
                    mysteriousRunes.remove(mysteriousRunes.size() - 1);
                }
                break;
        }

    }


    public void death(Player player) {
        player.health = player.maxHealth;
        player.mana = player.maxMana;
        player.gold = 0;
        player.status = "None";

    }

    public void levelUp() {
        switch(this.level) {
            case 1:
                if(this.exp >= 100) {
                    this.level++;
                    this.maxHealth += 50;
                    this.maxMana *= (int) 1.5;
                    BattleActivity.battleText.offer("Congratulations! You leveled up to level " + Integer.toString(this.level) + "!");
                }
                break;
            case 2:
                if(this.exp >= 250) {
                    this.level++;
                    this.maxHealth += 150;
                    this.maxMana *= 2;
                    BattleActivity.battleText.offer("Congratulations! You leveled up to level " + Integer.toString(this.level) + "!");
                }
                break;
            default:
                if(this.exp >= this.level * 500)
                {
                    this.level++;
                    this.maxHealth += this.level*50;
                    this.maxMana += this.level*100;
                    BattleActivity.battleText.offer("Congratulations! You leveled up to level " + Integer.toString(this.level) + "!");
                }
        }
    }



}
