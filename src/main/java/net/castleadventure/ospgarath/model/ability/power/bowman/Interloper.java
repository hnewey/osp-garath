package net.castleadventure.ospgarath.model.ability.power.bowman;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Interloper extends Power {

    public Interloper() {
        name = "Interloper";
        description = "You may interrupt an enemy’s movement within 6 spaces and make a ranged attack. If this attack is successful, the enemy’s movement stops immediately, and they are subject to a damage roll. Once this power is announced, the target may not alter their movement. If this attack fails, the power is not expended (Standard action/three times per game).";
    }
}
