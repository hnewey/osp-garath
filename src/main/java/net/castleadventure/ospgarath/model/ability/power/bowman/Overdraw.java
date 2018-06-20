package net.castleadventure.ospgarath.model.ability.power.bowman;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Overdraw extends Power {

    public Overdraw() {
        name = "Overdraw";
        description = "Make a ranged attack roll against any ability score of your target. If this attack is successful, you deal a damage roll and add an additional 1d6 damage. However, after this attack, roll 1d4. On a roll of “1” your bow breaks (Standard Action/once per game).";
    }
}
