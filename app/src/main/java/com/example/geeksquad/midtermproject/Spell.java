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
            case "GrassCannon":
                GrassCannon(user, target);
                break;
            case "ExplosiveEnchantment":
                ExplosiveEnchantment(user, target);
                break;
            case "ClearDay":
                ClearDay(user, target);
                break;
            case "DragonFocus":
                DragonFocus(user, target);
                break;
            case "IceArmor":
                IceArmor(user, target);
                break;
            case "RockFist":
                RockFist(user, target);
                break;
            case "Zap":
                Zap(user, target);
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
            case "GrassCannon":
                this.cost = 70;
                break;
            case "ExplosiveEnchantment":
                this.cost = 30;
                break;
            case "ClearDay":
                this.cost = 45;
                break;
            case "DragonFocus":
                this.cost = 30;
                break;
            case "IceArmor":
                this.cost = 10;
                break;
            case "RockFist":
                this.cost = 10;
                break;
            case "Zap":
                this.cost = 10;
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
            BattleActivity.battleText.offer(user.name + "'s fireball hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer(user.name + "unleashes multiple fireballs at " + target.name + " but they all fail to hit. ");
        }

    }

    public void Lightning(LifeForm user, LifeForm target) {
        int damage = 15;
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
            BattleActivity.battleText.offer(user.name + "'s lighting hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer(user.name + "'s barage of lighting fails to connect.");
        }

    }

    public void Frostbolt(LifeForm user, LifeForm target) {
        int damage = 6;
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
            BattleActivity.battleText.offer(user.name + "'s frostball hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer("The " + user.name + " only manage to give " + target.name + " a runny nose.");
        }

    }
    public void Dragonbreath(LifeForm user, LifeForm target) {
        int damage = 10;
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
            BattleActivity.battleText.offer(user.name + "'s dragonbreath hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer(user.name + " barely misses their attack!");
        }

    }

    public void Earthquake(LifeForm user, LifeForm target) {
        int damage = 15;
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
            BattleActivity.battleText.offer(user.name + "shook the ground hit dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer(user.name + "'s barage of lighting fails to connect.");
        }

    }

    public void GrassCannon(LifeForm user, LifeForm target) {
        int damage = 6;
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
            BattleActivity.battleText.offer("The " + user.name + "shot a grass cannon dealing " + Integer.toString(calcDamage) + " damage!");
        }
        else {
            //You missed
            BattleActivity.battleText.offer("The " + user.name + " only manage to give " + target.name + " a runny nose.");
        }

    }
    public void ExplosiveEnchantment(LifeForm user, LifeForm target) {
        MainActivity.player.spellMod++;
        BattleActivity.battleText.offer("The " + user.name + " pulled out a book and started reading it? The " + user.name + "'s spell damage increased!");
    }
    public void ClearDay(LifeForm user, LifeForm target) {
        MainActivity.player.accuracyMod++;
        BattleActivity.battleText.offer("The " + user.name + " cleared the sky, increasing his accuracy!");
    }
    public void DragonFocus(LifeForm user, LifeForm target) {
        MainActivity.player.defenseMod++;
        MainActivity.player.physicalMod++;
        BattleActivity.battleText.offer("The " + user.name + " used dragon runes to increase both his physical damage and defense!");
    }
    public void IceArmor(LifeForm user, LifeForm target) {
        MainActivity.player.defenseMod++;
        BattleActivity.battleText.offer("The " + user.name + " enchanted his armor with water runes, increasing his defense.");
    }
    public void RockFist(LifeForm user, LifeForm target) {
        MainActivity.player.physicalMod++;
        BattleActivity.battleText.offer("The " + user.name + " enchanted his fist with earth runes, increasing his physical damage.");
    }
    public void Zap(LifeForm user, LifeForm target) {
        target.status = "shocked";
        BattleActivity.battleText.offer("The " + user.name + " zapped the " + target.name + ", shocking him!");
    }
}
