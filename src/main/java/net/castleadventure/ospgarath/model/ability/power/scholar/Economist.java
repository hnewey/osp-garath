package net.castleadventure.ospgarath.model.ability.power.scholar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Economist extends Power {

    public Economist() {
        name = "Economist";
        description = "You may pay half price for any one purchasable item (Free Action/once per game).";
        powerCost = ".5";
    }
}
