package net.castleadventure.ospgarath.model.ability.power.brawler;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class GroundPound extends Power {

    public GroundPound() {
        name = "Ground and Pound";
        description = "You may make an attack roll or grapple maneuver as though determined against an enemy that is knocked over. If your attack is successful, you may add an additional 1d3 damage (Standard Action/once per game).";
        powerCost = ".5";
    }
}
