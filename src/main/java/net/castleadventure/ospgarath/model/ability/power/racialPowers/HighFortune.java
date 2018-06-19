package net.castleadventure.ospgarath.model.ability.power.racialPowers;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class HighFortune extends Power {

    public HighFortune() {
        name = "HighFortune";
        description = "You or an ally within 6 spaces may immediately re-roll a failed roll. If used to re-roll a critical fail roll, the affects of the critical fail still occur after the player\'s turn ends (Free Action/1 time per game).";
    }
}
