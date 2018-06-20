package net.castleadventure.ospgarath.model.ability.power.hunter;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ClipShot extends Power {

    public ClipShot() {
        name = "Clip Shot";
        description = "Make a ranged attack. If successful, the target is immobilized and takes damage. If the attack fails, the power is not expended (Standard Action/3 times per game).";
    }
}
