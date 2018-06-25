package net.castleadventure.ospgarath.model.ability.power.scholar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Pathologist extends Power {

    public Pathologist() {
        name = "Pathologist";
        description = "You or a teammate within 6 spaces may automatically succeed at a roll to heal a poison or resist the effects of a disease (Standard Action/once per game).";
        powerCost = ".5";
    }
}
