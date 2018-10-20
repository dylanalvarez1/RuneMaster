package com.example.geeksquad.midtermproject;

public class Spell {
    public String name, type, status;
    public float levelMod;
    public int cost;
    Spell(String name, String type, float levelMod, String status) {
        this.name = name;
        this.type = type;
        this.levelMod = levelMod;
        this.status = status;
        setCost(name);
    }
    public void use(LifeForm user, LifeForm target, String name) {
        switch(name) {
            case "Fireball":
                Fireball(user, target);
                break;
            case "Lightning":
                Lightning(user, target);
                break;
            case "Frostbolt":
                Frostbolt(user, target);
                break;
            case "Dragonbreath":
                Dragonbreath(user, target);
                break;
            case "Earthquake":
                Earthquake(user, target);
                break;
            case "Solarbeam":
                Solarbeam(user, target);
                break;

        }
    }
    public void setCost(String name) {
        switch(name) {
            case "Fireball":
                this.cost = 15;
                break;
            case "Lightning":
                this.cost = 20;
                break;
            case "Frostbolt":
                this.cost = 10;
                break;
            case "Dragonbreath":
                this.cost = 25;
                break;
            case "Earthquake":
                this.cost = 60;
                break;
            case "Solarbeam":
                this.cost = 70;
                break;

        }
    }


    public boolean willHit(String status, int accuracy) {
        if( Math.random() < (float) (accuracy /100.0)) {
            return true;
        }
        if(status == "shocked" && Math.random() >= .25) {
            return false;
        }
        return false;
    }

    public void Fireball(LifeForm user, LifeForm target) {
        int damage = 10;
        int manaCost = 10;
        int accuracy = 80;
        int modifier = 1;



        if(target.type == "ice") {
            modifier = 2;
        }
        if(this.willHit(target.status, accuracy)) {
            //TODO: Make sure that the def is never larger than the damage
            int calcDamage = (int) ((damage * modifier * this.levelMod) - target.def);
            target.health -= calcDamage;
            if(target.health < 0) target.health = 0;
            BattleActivity.battleText.offer("The fireball hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer("You unleash fireballs but they all fail to hit. :(");
        }

    }

    public void Lightning(LifeForm user, LifeForm target) {
        int damage = 15;
        int manaCost = 20;
        int accuracy = 60;
        int modifier = 1;



        if(target.type == "water") {
            modifier = 2;
        }
        if(this.willHit(user.status, accuracy)) {
            //TODO: Make sure that the def is never larger than the damage
            int calcDamage = (int) ((damage * modifier * this.levelMod) - target.def);
            target.health -= calcDamage;
            if(target.health < 0) target.health = 0;
            BattleActivity.battleText.offer("The lighting hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer("Your barage of lighting fails to connect.");
        }

    }

    public void Frostbolt(LifeForm user, LifeForm target) {
        int damage = 6;
        int manaCost = 100;
        int accuracy = 90;
        int modifier = 1;



        if(target.type == "fire") {
            modifier = 2;
        }
        if(this.willHit(user.status, accuracy)) {
            //TODO: Make sure that the def is never larger than the damage
            int calcDamage = (int) ((damage * modifier * this.levelMod) - target.def);
            target.health -= calcDamage;
            if(target.health < 0) target.health = 0;
            BattleActivity.battleText.offer("The frostball hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer("You only manage to give him a runny nose.");
        }

    }
    public void Dragonbreath(LifeForm user, LifeForm target) {
        int damage = 10;
        int manaCost = 10;
        int accuracy = 80;
        int modifier = 1;


        if(target.type == "ice") {
            modifier = 2;
        }
        if(this.willHit(target.status, accuracy)) {
            //TODO: Make sure that the def is never larger than the damage
            int calcDamage = (int) ((damage * modifier * this.levelMod) - target.def);
            target.health -= calcDamage;
            if(target.health < 0) target.health = 0;
            BattleActivity.battleText.offer("The dragonbreath hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer("You unleash fireballs but they all fail to hit. :(");
        }

    }

    public void Earthquake(LifeForm user, LifeForm target) {
        int damage = 15;
        int manaCost = 20;
        int accuracy = 60;
        int modifier = 1;



        if(target.type == "water") {
            modifier = 2;
        }
        if(this.willHit(user.status, accuracy)) {
            //TODO: Make sure that the def is never larger than the damage
            int calcDamage = (int) ((damage * modifier * this.levelMod) - target.def);
            target.health -= calcDamage;
            if(target.health < 0) target.health = 0;
            BattleActivity.battleText.offer("The earth hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer("Your barage of lighting fails to connect.");
        }

    }

    public void Solarbeam(LifeForm user, LifeForm target) {
        int damage = 6;
        int manaCost = 100;
        int accuracy = 90;
        int modifier = 1;



        if(target.type == "fire") {
            modifier = 2;
        }
        if(this.willHit(user.status, accuracy)) {
            //TODO: Make sure that the def is never larger than the damage
            int calcDamage = (int) ((damage * modifier * this.levelMod) - target.def);
            target.health -= calcDamage;
            if(target.health < 0) target.health = 0;
            BattleActivity.battleText.offer("The grass hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer("You only manage to give him a runny nose.");
        }

    }
}
