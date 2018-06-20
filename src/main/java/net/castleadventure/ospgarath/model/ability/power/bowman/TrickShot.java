package net.castleadventure.ospgarath.model.ability.power.bowman;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class TrickShot extends Power {

    public TrickShot() {
        name = "Trick Shot";
        description = "The bowman may target multiple enemies within range, but must take a roll penalty to each attack equal to the number of all additional enemies targeted beyond the first (Standard action/three times per game).";
    }
}
