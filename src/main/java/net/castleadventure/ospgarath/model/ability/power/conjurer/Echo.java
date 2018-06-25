package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Echo extends Power {

    public Echo() {
        name = "Echo";
        description = "You may immediately direct the failed use of a power to a different target within 3 spaces of your original target, and roll accordingly against your new target (Free Action/once per game).";
        powerCost = ".5";
    }
}
