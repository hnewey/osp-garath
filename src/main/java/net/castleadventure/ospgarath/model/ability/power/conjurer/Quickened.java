package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Quickened extends Power {

    public Quickened() {
        name = "Quickened";
        description = "You quicken the use of a power. A power that requires a Standard Action may be used as a Quick Action. A power that requires a Quick Action may be used as a Free Action (Free Action/once per game).";
        powerCost = ".5";
    }
}
