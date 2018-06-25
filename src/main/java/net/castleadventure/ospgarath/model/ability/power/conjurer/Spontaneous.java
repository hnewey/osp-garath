package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Spontaneous extends Power {

    public Spontaneous() {
        name = "Spontaneous";
        description = "You may use a power with the word “spell” in its title without provoking a free attack from adjacent targets. You may still provoke free attacks from other applicable movements and actions (Free Action/once per game).";
        powerCost = ".5";
    }
}
