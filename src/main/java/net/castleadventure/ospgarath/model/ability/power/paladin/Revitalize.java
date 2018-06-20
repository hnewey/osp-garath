package net.castleadventure.ospgarath.model.ability.power.paladin;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Revitalize extends Power {

    public Revitalize() {
        name = "Revitalize";
        description = "You may roll to heal an adjacent teammate a number of points from (1-3)+L bonus.  If not in combat, re-roll a roll of 1. (Standard Action/3 times per game).";
    }
}
