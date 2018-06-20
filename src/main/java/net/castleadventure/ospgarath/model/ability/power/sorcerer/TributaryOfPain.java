package net.castleadventure.ospgarath.model.ability.power.sorcerer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class TributaryOfPain extends Power {

    public TributaryOfPain() {
        name = "Tributary of Pain Spell";
        description = "Make a roll with a range of (1-I bonus)+1. A number of enemies equal to your roll result within 6 spaces of you are now subject to you making an I vs L roll against them. The successful rolls result in either damage rolls or the targets bleeding and immobilized.  If you succeed your roll by 10 or more, they are also paralyzed for one round. (Standard Action/3 times per game).";
    }
}
