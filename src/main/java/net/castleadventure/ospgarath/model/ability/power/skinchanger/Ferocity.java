package net.castleadventure.ospgarath.model.ability.power.skinchanger;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Ferocity extends Power {

    public Ferocity() {
        name = "Ferocity";
        description = "When in beast form, roll two dice for a basic melee damage roll and choose the more favorable roll.  If this damage drops the enemy to 0 E points, you roll to heal E points ranging from (1-S bonus) +1 (Free Action/3 times per game).";
    }
}
