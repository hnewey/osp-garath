package net.castleadventure.ospgarath.model.ability.power.racialPowers;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class HobbitLuck extends Power {

    public HobbitLuck() {
        name = "Hobbit Luck";
        description = "Upon rolling a natural 1, the hobbit may immediately end their current turn and take a new turn, ignoring any critical fail effects (Free Action/unlimited).";
        powerCost = "0";
    }
}
