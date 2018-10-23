# Spell Master
- Find items, cast spells, and fight monsters!
- Developed using Android Studio, Google Maps API


## How to play:
### Definitions:
#### Items
- Items are consumable objects that the player can utilize to help them in battle
- Items can be found on the map after walking to them and picking them up
- The types of items are Health Potion, Mana Potion, and Mysterious Rune:
  - Health Potion heals the player to max health
  - Mana Potion restores all the mana the player has
  - Mysterious Rune casts a random spell
  
#### Spells
- Spells are a type of attack that the player can use that cost mana
- A player has 3 spells that they can use in battle at a time
- Spells each have a base damage, type, status, cost, accuracy
- Spells are more effective based off of this hierarchy: fire->ice->grass->ground->electric->water->fire
- Certain spells can miss, some can also apply status effects to enemies such as burn (does damage each turn), shock (lowers accuracy) or freeze (removes any buffs)
- In the about page, you can change the 3 spells you want to use in battle
- Currently, half of the spells deal damage, and the other half deal status/buff, see which spells work for you!
- Certain buff spells increase the damage of your other spells, your physical damage, or your defense (resistance to damage)

### Search for items
- This activity is where the player goes to get some items to help them win fights
- Using Google maps API and the device's location, all you need to do is click the location button in the upper left hand corner to find yourself on the map
- All you need to do now is walk around and once your near an item (the chest) on the map, click it to pick it up

### Fight a battle
- This activity has all the relavant monster stats at the top of the screen and the relavent player status above the colorful buttons at the bottom of the screen
- Each monster is randomly generated and has different moves, types, status based off of their level and their name (i.e elder fire dragon is going to be a really strong fire type)
- The colorful buttons are the different actions that the player can take during a battle
- The player can do a basic attack with the "attack" button, or choose to cast a spell on the monster with the "cast spell" button (if they have mana)
- The player can use an item (if they have it) by clicking the "items" button
- To leave the battle without either winning or loosing, hit the "Run" button
- Every single action by both the player or the enemy will update the Event log text, so be sure to follow along to understand the flow of battle
- If the player dies, he responds with full health/mana and no status, but looses gold
- If the player wins, he gets gold and exp (which can level him up if he has enough)

### Check your Stats
- This activity is where the player goes to configure their character
- The players stats can be viewed outside of battle
- The player can also change their spell configuration here by hitting the "set spell" button
- The player can also "recover at the castle" which cost gold in exchange for recovering their status, health and mana


