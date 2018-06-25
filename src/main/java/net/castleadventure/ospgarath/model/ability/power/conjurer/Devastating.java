package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Devastating extends Power {

    public Devastating() {
        name = "Devastating";
        description = "When one of your powers causes damage to an enemy target, you may may make that damage roll as though determined, choosing between the higher result of two similar damage dice (Free Action/once per game).";
        powerCost = ".5";
    }
}
