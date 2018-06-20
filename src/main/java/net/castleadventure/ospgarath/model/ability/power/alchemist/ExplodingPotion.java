package net.castleadventure.ospgarath.model.ability.power.alchemist;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ExplodingPotion extends Power {

    public ExplodingPotion() {
        name = "Exploding Spell Potion";
        description = "Pick a specific occupied or unoccupied square within six squares of you. All creatures within 1 square of the square you choose must make a Q 15 roll or else be knocked over and take damage on a roll ranging from (1-I Bonus) +1. (Standard Action/3 times per game).";
    }

}
