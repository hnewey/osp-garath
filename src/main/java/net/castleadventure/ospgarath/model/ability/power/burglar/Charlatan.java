package net.castleadventure.ospgarath.model.ability.power.burglar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Charlatan extends Power {

    public Charlatan() {
        name = "Charlatan";
        description = "You may assume the identity of any character whose clothes or armor you have equipped. This lasts for one encounter and is opposed by an L vs Q roll of the highest enemy leadership score affected (Free Action/once per game).";
        powerCost = ".5";
    }
}
