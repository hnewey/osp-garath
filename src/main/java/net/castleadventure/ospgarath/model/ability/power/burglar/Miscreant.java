package net.castleadventure.ospgarath.model.ability.power.burglar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Miscreant extends Power {

    public Miscreant() {
        name = "Miscreant";
        description = "You may sell one item to a merchant at full price instead of at half price (Free Action/once per game).";
        powerCost = ".5";
    }
}
