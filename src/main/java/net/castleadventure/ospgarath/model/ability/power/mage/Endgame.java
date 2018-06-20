package net.castleadventure.ospgarath.model.ability.power.mage;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Endgame extends Power {

    public Endgame() {
        name = "Endgame";
        description = "After a successful melee attack in which you deal damage to an adjacent target, you may choose to add an additional damage dice for every four Endurance points you are willing to sacrifice. You cannot add a number of damage dice that would cause your Endurance to fall to a number less than 0. (Free Action/1 time per game).";
    }
}
