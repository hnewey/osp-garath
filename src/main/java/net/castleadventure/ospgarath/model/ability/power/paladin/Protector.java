package net.castleadventure.ospgarath.model.ability.power.paladin;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Protector extends Power {

    public Protector() {
        name = "Protector";
        description = "You may grant one (max) adjacent teammate up to a +5 bonus to defense. However, this amount is subtracted from your defense, and the effect ends if you and the teammate are no longer adjacent. This lasts for one round (Free Action/unlimited).";
    }
}
