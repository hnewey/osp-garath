package net.castleadventure.ospgarath.model.ability.power.barbarian;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class HotBlooded extends Power {

    public HotBlooded() {
        name = "Hot Blooded";
        description = "Make a melee attack roll of any type that adds one damage dice for every -3 attack roll penalty you apply to the roll. There is no limit to the number of damage dice/roll penalties you may add, but using this against a paralyzed enemy requires an attack roll with the end result exceeding 0, or else the power fails and is lost (Standard Action/1 time per game).";
    }

}
