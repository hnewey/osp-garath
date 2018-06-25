package net.castleadventure.ospgarath.model.ability.power.beast;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Pester extends Power {

    public Pester() {
        name = "Pester";
        description = "May pester an adjacent target by rolling Q v I or Q v L. If successful, the next character to perform a ranged attack on that target before this the end of this animal’s next turn, may roll twice and choose the more favorable outcome (Quick Action/unlimited).";
    }
}
