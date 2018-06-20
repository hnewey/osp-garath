package net.castleadventure.ospgarath.model.ability.power.sovereign;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class InspiringCry extends Power {

    public InspiringCry() {
        name = "Inspiring Cry Command";
        description = "Make a roll ranging from (1-L bonus) +1. A number of teammates or followers equal to your roll who are within 6 spaces may immediately make an attack on an enemy within their range. If none of these attacks are successful, the power is not expended (Standard Action/3 times per game).";
    }
}
