package net.castleadventure.ospgarath.model.ability.power.beast;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Ferocious extends Power {

    public Ferocious() {
        name = "Ferocious";
        description = "Roll an extra dice for a basic melee damage roll. If this drops the enemy to 0 E points, roll to heal E points ranging from 1-3 (Free Actions/3 times per game).";
    }
}
