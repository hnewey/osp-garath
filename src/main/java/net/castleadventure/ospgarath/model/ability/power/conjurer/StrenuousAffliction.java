package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class StrenuousAffliction extends Power {

    public StrenuousAffliction() {
        name = "Strenuous Affliction Spell";
        description = "You pick one target within 6 spaces and make an I vs I roll against the target. If successful, make a damage roll ranging from 1-I Bonus. In addition, whether or not your roll is successful, roll a six sided dice and cause the corresponding condition to affect your target:\n" +
                "1- Paralyzed      2- Weakened                  3- Bleeding\n" +
                "4- Exhausted    5- Immobilized               6- Nothing\n";
    }
}
