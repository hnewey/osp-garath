package net.castleadventure.ospgarath.model.ability.power.sorcerer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class MindFlayer extends Power {

    public MindFlayer() {
        name = "Mind Flayer Spell";
        description = "You may make an intelligence roll against the intelligence of any enemy within 6 spaces. If successful, you may immediately force that enemy to attack a target within its attack range, or move up to its full standard movement distance. If the initial I vs. I roll fails, the use of this power is not expended (Standard Action/3 times per game).";
    }
}
