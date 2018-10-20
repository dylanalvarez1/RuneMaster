package com.example.geeksquad.midtermproject;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends LifeForm{

    public int  maxMana, gold;
    public int exp = 0;
    public String type;


    //Amount of runes
    public int earth, electric, fire, water, ice, dragon;


    Player(String name, int health, int mana, int level, int damage, int def, int gold, String status, String type) {
        super(name, health, mana, level, damage, def, status, type);
        this.maxMana = mana;
        this.gold = gold;
        earth = electric = fire = water = ice = dragon = 0;
    }

    public void levelUp() {
        switch(this.level) {
            case 1:
                if(this.exp > 100) {
                    this.level++;
                    BattleActivity.battleText.offer("Congradulations! You leveled up to level " + Integer.toString(this.level) + "!");
                }
                break;
            case 2:
                if(this.exp > 250) {
                    this.level++;
                    BattleActivity.battleText.offer("Congradulations! You leveled up to level " + Integer.toString(this.level) + "!");
                }
                break;
            default:
                if(this.exp > this.level * 500)
                {
                    this.level++;
                    BattleActivity.battleText.offer("Congradulations! You leveled up to level " + Integer.toString(this.level) + "!");
                }
        }
    }

}
