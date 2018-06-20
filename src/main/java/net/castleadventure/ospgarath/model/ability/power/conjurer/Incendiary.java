package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Incendiary extends Power {

    public Incendiary() {
        name = "Incendiary";
        description = "After one of your powers causes damage to an enemy target, you may cause it to gain the “on fire” condition unless it succeeds on a L vs I roll against you (Free Action/once per game).";
    }
}
