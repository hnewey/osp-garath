package net.castleadventure.ospgarath.model.ability.power.mariner;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class CalledShot extends Power {

    public CalledShot() {
        name = "Called Shot";
        description = "Make a basic melee attack with a +1 bonus. This attack deals no damage but instead cripples your target’s leg, arm, or head. If successful, your target gains a negative condition with one of the following effects, based on the area you are targeting:\n" +
                "leg- your target is slowed\n" +
                "arm-your target cannot use or equip anything with this arm\n" +
                "head- your target is hampered \n" +
                "If your attack is unsuccessful, this power is not expended (Standard Action/3 times per game).\n";
    }
}
