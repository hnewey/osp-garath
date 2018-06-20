package net.castleadventure.ospgarath.model.ability.power.barbarian;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Animosity extends Power {

    public Animosity() {
        name = "Animosity";
        description = "You gain a condition in which your endurance cannot be damaged. This condition must be maintained at the start of each turn. While it persists, you make two attacks per turn. However, all attacks against you automatically succeed, and damage is rolled as normal, though you do not suffer it or negative conditions. However, once this condition ends, you must succeed on a S 10 roll or else fall unconscious, your endurance reduced to 0. This roll is increased by the amount of any damage that the barbarian suffered while using this power (Free Action/1 time per game).";
    }

}
