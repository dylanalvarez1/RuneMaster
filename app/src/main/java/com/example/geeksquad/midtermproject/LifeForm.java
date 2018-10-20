package com.example.geeksquad.midtermproject;

import java.util.ArrayList;

public class LifeForm {
    public int health, mana, maxHealth, level, damage, def;
    public String name, status, type;
    public int physicalMod;
    public int accuracyMod;
    public int defenseMod;
    public int spellMod;
    public int imageSource;
    public ArrayList<Spell> mySpells = new ArrayList<Spell>(3);
    public Spell loadedSpell = null;

    public LifeForm(String name, int health, int mana, int level, int def, String status, String type, int imageSource) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.mana = mana;
        this.level = level;
        this.def = def;
        this.status = status;
        this.type = type;
        this.imageSource = imageSource;

        this.physicalMod = 1;
        this.accuracyMod = 1;
        this.defenseMod = 1;
        this.spellMod = 1;


    }

    public void randomAttack(LifeForm target) {
        int random = getRandomNumberInRange(0, 3);
        switch(random) {
            case 0:
                castSpell(target, getSpell(0));
                break;
            case 1:
                castSpell(target, getSpell(1));
                break;
            case 2:
                castSpell(target, getSpell(2));
                break;
            case 4:
                basicAttack(target);
                break;
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public void basicAttack(LifeForm target) {
        target.health -= 10;
        if(target.health < 0) target.health = 0;
        BattleActivity.battleText.offer("The " + this.name + " walked up and hit the " + target.name+ "!");
        /*
        if(target.def < this.damage) {
            //A basic attack, although its weak
            //target.health -= (int) (this.damage - target.def);
            target.health = 20;
        } */

    }

    public void castSpell(LifeForm target, Spell spell) {
        spell.use(this, target, spell.name);
    }

    public void setSpell(Spell spellToInsert, int index) {
        //Set one of the three spells you can have
        mySpells.add(index, spellToInsert);
        /*
        if(mySpells.get(index) != null) {
            mySpells.remove(index);
            mySpells.add(index, spellToInsert);
        }
        else {
            mySpells.add(index, spellToInsert);
        }
        */

    }
    public Spell getSpell(int index) {
        return mySpells.get(index);
    }

    public void clearModifiers() {
        this.physicalMod = 1;
        this.accuracyMod = 1;
        this.defenseMod = 1;
    }

    public void deathEvent() {
        MainActivity.player.exp += this.level * 10;
        MainActivity.player.gold += this.level * 50;
    }

}
