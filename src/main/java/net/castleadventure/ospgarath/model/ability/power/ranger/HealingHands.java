package net.castleadventure.ospgarath.model.ability.power.ranger;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class HealingHands extends Power {

    public HealingHands() {
        name = "Healing Hands";
        description = "You may roll to heal a teammate a number of E points ranging from (1-3) + Int. bonus. If not done in combat, you may re-roll any rolls of 1 (Standard Action/3 times per game).";
    }
}
