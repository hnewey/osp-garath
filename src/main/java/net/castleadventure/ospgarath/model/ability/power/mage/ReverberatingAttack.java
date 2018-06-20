package net.castleadventure.ospgarath.model.ability.power.mage;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ReverberatingAttack extends Power {

    public ReverberatingAttack() {
        name = "Reverberating Attack";
        description = "After a successful attack, you may choose to apply any number of the following condition to the target of your attack: exhausted, immobile, hampered, staggered, and shaken. However, these same conditions that you choose take effect on you (Standard Action/1 time per game).";
    }
}
