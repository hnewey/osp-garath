package net.castleadventure.ospgarath.model.ability.power.mage;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ForcePulse extends Power {

    public ForcePulse() {
        name = "Force Pulse";
        description = "All characters on spaces adjacent to you must succeed on a I vs S roll against you or else be pushed in a straight line away from you a number of spaces equal to your I Bonus +1. Any character that fails this roll by 5 or more is also knocked over (Quick Action/3 times per game).";
    }
}
