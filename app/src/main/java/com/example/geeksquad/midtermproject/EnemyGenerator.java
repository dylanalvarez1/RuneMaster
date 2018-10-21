package com.example.geeksquad.midtermproject;

import android.view.View;

public class EnemyGenerator {
    EnemyGenerator() {}

    public static LifeForm newEnemy() {

        //Generate the name for the enemy
        LifeForm enemy = createEnemy();

        //Set the spells for the enemy
        int spellIndex = 0;
        for(int i = 0; i < 3; i++) {
            int rand = getRandomNumberInRange(0, 11);
            enemy.setSpell(chooseSpell(rand), spellIndex++);
        }
        return enemy;
    }

    public static LifeForm createEnemy() {
        int random1 = getRandomNumberInRange(0, 4);
        int random2 = getRandomNumberInRange(0, 4);
        int random3 = getRandomNumberInRange(0, 6);
        String name = "";
        String adj1 = "";
        String adj2 = "";
        String noun = "";
        int level = 1;
        String type = "";
        int health = 1;
        int mana = 1;
        int def = 1;
        String status = "None";
       int imageSource = 0;

        switch(random1) {
            case 0:
                adj1 += "Elder ";
                level = 40;
                break;
            case 1:
                adj1 += "Large ";
                level = 30;
                break;
            case 2:
                adj1 += "";
                level = 20;
                break;
            case 3:
                adj1 += "Ancient ";
                level = 40;
                break;
            case 4:
                adj1 += "Lesser ";
                level = 10;
                break;
        }

        health *= 5 * level;

        switch(random2) {
            case 0:
                adj2 += "Fire ";
                type = "fire";
                break;
            case 1:
                adj2 += "Frost ";
                type = "ice";
                break;
            case 2:
                adj2 += "Thunder ";
                type = "electric";
                break;
            case 3:
                adj2 += "Stone ";
                type = "ground";
                break;
            case 4:
                adj2 += "Nature ";
                type = "grass";
                break;
        }

        switch(random3) {
            case 0:
                noun += "Ogre";
                health += 15;
                imageSource = R.drawable.orchead;
                break;
            case 1:
                noun += "Dragon";
                health += 50;
                imageSource = R.drawable.spikeddragonhead;
                break;
            case 2:
                noun += "Lizard";
                health += 5;
                imageSource = R.drawable.dragonhead2;
                break;
            case 3:
                noun += "Elemental";
                health += 20;
                imageSource = R.drawable.sparkspirit;
                break;
            case 4:
                noun += "Demon";
                health += 10;
                imageSource = R.drawable.evilminion;
                break;
            case 5:
                noun += "Giant";
                health += 30;
                imageSource = R.drawable.giant;
                break;
            case 6:
                noun += "Golem";
                health += 25;
                imageSource = R.drawable.icegolem;
                break;
        }
        def = level;
        return new LifeForm(adj1 + adj2 + noun, health, mana, level, def, status, type, imageSource);
    }



    public static Spell chooseSpell(int choice) {
        switch(choice) {
            case 0:
                return new Spell("Fireball", "fire", 1, "burned");
            case 1:
                return new Spell("Lightning", "electric", 1, "shocked");
            case 2:
                return new Spell("Frostbolt", "ice", 1, "freezed");
            case 3:
                return new Spell("Dragonbreath", "dragon", 1, "none");
            case 4:
                return new Spell("Earthquake", "ground", 1, "none");
            case 5:
                return new Spell("GrassCannon", "grass", 1, "none");
            case 6:
                return new Spell("ExplosiveEnchantment", "fire", 1, "none");
            case 7:
                return new Spell("ClearDay", "grass", 1, "none");
            case 8:
                return new Spell("DragonFocus", "dragon", 1, "none");
            case 9:
                return new Spell("IceArmor", "ice", 1, "none");
            case 10:
                return new Spell("RockFist", "ground", 1, "none");
            case 11:
                return new Spell("Zap", "electric", 1, "none");

        }
        //Should never get here
        return null;
    }
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
