package net.castleadventure.ospgarath.model.ability.power.captain;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class MenacingThreat extends Power {

    public MenacingThreat() {
        name = "Menacing Threat Command";
        description = "When a non-villain enemy fails an attack against one of your adjacent teammates, you may force that enemy to make an L vs L roll against you. If they fail this roll, the enemy must use its next turn to move its full movement in a direction away from you, forfeiting its quick action and standard action (Free Action/once per game).";
        powerCost = ".5";
    }
}
