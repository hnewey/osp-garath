package net.castleadventure.ospgarath.model.ability.power.ranger;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class DeadlyRange extends Power {

    public DeadlyRange() {
        name = "Deadly Range";
        description = "Make a ranged attack with a +2 bonus. If successful, roll damage as though it were a melee attack instead of a ranged attack. If unsuccessful the power is not expended (Standard Action/3 times per game).";
    }
}
