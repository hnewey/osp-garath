package net.castleadventure.ospgarath.model.ability.power.healer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class HeroicRevive extends Power {

    public HeroicRevive() {
        name = "Heroic Revive Spell";
        description = "You may revive and heal an adjacent target that has perished if you can reach them within 1 round of when they perished and succeed on a Int. 8 roll. Target character is revived with 1 Endurance point (Standard Action/1 time per game).";
    }
}
