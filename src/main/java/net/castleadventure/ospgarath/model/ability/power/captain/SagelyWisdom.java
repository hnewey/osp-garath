package net.castleadventure.ospgarath.model.ability.power.captain;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class SagelyWisdom extends Power {

    public SagelyWisdom() {
        name = "Sagely Wisdom Command";
        description = "In combat, you may add a d5 to the roll of a teammate within 3 spaces who is attempting to make a heal, resist, identify, or evaluation roll (Free Action/once per game).";
        powerCost = ".5";
    }
}
