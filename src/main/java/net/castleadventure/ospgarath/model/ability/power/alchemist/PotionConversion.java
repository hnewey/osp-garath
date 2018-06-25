package net.castleadventure.ospgarath.model.ability.power.alchemist;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class PotionConversion extends Power {

    public PotionConversion() {
        name = "Spell Potion Conversion";
        description = "You may turn any one non-relic potion in your inventory into another non-relic potion of a different type (Standard Action/once per game).";
        powerCost = ".5";
    }

}
