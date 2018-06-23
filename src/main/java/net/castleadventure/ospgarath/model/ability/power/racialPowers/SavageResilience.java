package net.castleadventure.ospgarath.model.ability.power.racialPowers;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class SavageResilience extends Power {

    public SavageResilience() {
        name = "Savage Resilience";
        description = "Upon reaching 0 E points or less, you may choose to not fall unconscious if you can succeed on an L 5 roll. However, each time this is used in a game the L roll required increases by 5, and you can still die if you are damaged while at or below 0 hit points (Free Action/unlimited).";
        powerCost = "0";
    }
}
