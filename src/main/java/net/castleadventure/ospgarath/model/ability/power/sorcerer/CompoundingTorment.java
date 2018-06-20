package net.castleadventure.ospgarath.model.ability.power.sorcerer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class CompoundingTorment extends Power {

    public CompoundingTorment() {
        name = "Compounding Torment Spell";
        description = "Force a target within six spaces of you to make an L vs I roll against you. If the target fails this roll, it suffers a number of damage rolls from you for every 4 roll amounts by which it failed its roll (Standard Action/1 time per game).";
    }
}
