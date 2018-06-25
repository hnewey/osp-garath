package net.castleadventure.ospgarath.model.ability.power.captain;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class SteadyingPresence extends Power {

    public SteadyingPresence() {
        name = "Steadying Presence Command";
        description = "You may choose one teammate within 3 spaces to gain the Steadied condition (Quick Action/once per game).";
        powerCost = ".5";
    }
}
