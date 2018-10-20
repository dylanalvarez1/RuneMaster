package com.example.geeksquad.midtermproject;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends LifeForm{

    public int  maxMana, gold;
    public int exp = 0;
    public String type;


    //Amount of runes
    public int earth, electric, fire, water, ice, dragon;


    Player(String name, int health, int mana, int level, int damage, int def, int gold, String status, String type, int imageSource) {
        super(name, health, mana, level, def, status, type, imageSource);
        this.maxMana = mana;
        this.gold = gold;
        earth = electric = fire = water = ice = dragon = 0;
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
