package net.castleadventure.ospgarath.model.ability.power.beast;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Stoop extends Power {

    public Stoop() {
        name = "Stoop";
        description = "Make a quick attack roll against base quickness, adding a +1 roll bonus for every 2 spaces of movement made prior to the attack, so long as the whole movement was made in a straight line. If successful, the attack deals damage and the target becomes exhausted. If the attack succeeds by 5 or more, the target is also bloodied (Standard Action/3 times per game).";
    }
}
