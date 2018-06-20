package net.castleadventure.ospgarath.model.ability.power.weaponmaster;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Deflect extends Power {

    public Deflect() {
        name = "Deflect";
        description = "When wielding your weapon of choice, you gain a +1 to defense. This is in addition to other weapon and armor bonuses, but adds no additional penalties. If wielding a two handed melee weapon, ignore the defense penalty instead of adding +1 to defense, unless the two handed weapon has no defense penalty (Innate/unlimited).";
    }
}
