package com.example.geeksquad.midtermproject;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends LifeForm{

    public int  maxMana, gold;
    public String type;


    //Amount of runes
    public int earth, electric, fire, water, ice, dragon;


    Player(int health, int mana, int level, int damage, int def, int gold, String status, String type) {
        super(health, mana, level, damage, def, status, type);
        this.maxMana = mana;
        this.gold = gold;
        earth = electric = fire = water = ice = dragon = 0;
    }

}
