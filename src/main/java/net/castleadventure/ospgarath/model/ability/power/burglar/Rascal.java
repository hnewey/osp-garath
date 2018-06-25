package net.castleadventure.ospgarath.model.ability.power.burglar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Rascal extends Power {

    public Rascal() {
        name = "Rascal";
        description = "You may automatically succeed at any attempt to disarm a trap, or to evade a trap that has been triggered, instead of making a roll to do so (Free Action/once per game).";
        powerCost = ".5";
    }
}
