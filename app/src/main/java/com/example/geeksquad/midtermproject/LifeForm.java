package com.example.geeksquad.midtermproject;

import java.util.ArrayList;
import java.util.Collection;

public class LifeForm {
    public int health, mana, maxHealth, level, damage, def;
    public String status, type;
    public ArrayList<Spell> mySpells = new ArrayList<Spell>(3);

    public LifeForm(int health, int mana, int level, int damage, int def, String status, String type) {
        this.health = health;
        this.maxHealth = health;
        this.mana = mana;
        this.level = level;
        this.def = def;
        this.status = status;
        this.type = type;


    }

    public void basicAttack(LifeForm target) {
        if(target.def < this.damage) {
            //A basic attack, although its weak
            target.health -= (int) (this.damage - target.def);
        }

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



}
