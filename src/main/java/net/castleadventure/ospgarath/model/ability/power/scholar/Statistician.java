package net.castleadventure.ospgarath.model.ability.power.scholar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Statistician extends Power {

    public Statistician() {
        name = "Statistician Command";
        description = "When a teammate within 6 spaces fails on an attack roll, you may immediately let that teammate re-roll their same attack, adding your leadership or intelligence bonus to their roll. If the roll is still unsuccessful, this power is not expended (Free Action/3 times per game).";
    }
}
