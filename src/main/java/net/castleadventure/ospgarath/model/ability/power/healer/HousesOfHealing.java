package net.castleadventure.ospgarath.model.ability.power.healer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class HousesOfHealing extends Power {

    public HousesOfHealing() {
        name = "Houses of Healing Spell";
        description = "An adjacent teammate heals an amount of endurance points equal to a roll ranging from (1-I Bonus)+2 (Standard Action/3 times per game).";
    }
}
