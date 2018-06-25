package net.castleadventure.ospgarath.model.ability.power.brawler;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ShoulderThrow extends Power {

    public ShoulderThrow() {
        name = "Shoulder Throw";
        description = "After you make a successful throw maneuver or push attack against an enemy target, you may cause that target to take a damage roll from you if it strikes a wall or another enemy (Free Action/once per game).";
        powerCost = ".5";
    }
}
