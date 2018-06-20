package net.castleadventure.ospgarath.model.ability.power.shepherd;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class AnimalStrategy extends Power {

    public AnimalStrategy() {
        name = "Animal Strategy Command";
        description = "At the end of a turn in which only an animal was controlled instead of the shepherd, you may immediately make a melee or ranged attack with the shepherd. If the attack is successful, the animal controlled on this turn may make another full movement without provoking a free attack. If your attack fails, this power is not expended (Free Action/3 times per game).";
    }
}
