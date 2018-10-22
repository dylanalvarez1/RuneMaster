package com.example.geeksquad.midtermproject;

public class Item {

    public String name;

    Item(String name) {
        this.name = name;
    }

    public void use(Player user, LifeForm target, String name) {
        switch(name) {
            case "Health Potion":
                heal(user);
                break;
            case "Mana Potion":
                restore(user);
                break;
            case "Mysterious Rune":
                cast(user, target);
                break;
        }
    }

    public void heal(Player user) {
        user.health = user.maxHealth;
        BattleActivity.battleText.offer(user.name + "drank a healing potion and regained his health!");
    }

    public void restore(Player user) {
        user.mana = user.maxMana;
        BattleActivity.battleText.offer(user.name + "drank a mana potion and regained his mana!");
    }

    public void cast(LifeForm user, LifeForm target) {
       int choice = getRandomNumberInRange(0,11);
       Spell spell = chooseSpell(choice);
        BattleActivity.battleText.offer(user.name + "used a mysterious rune to cast a random spell!");
       spell.use(user, target, spell.name);
    }



    public Spell chooseSpell(int choice) {
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
