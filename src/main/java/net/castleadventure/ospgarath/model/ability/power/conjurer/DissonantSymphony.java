package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class DissonantSymphony extends Power {

    public DissonantSymphony() {
        name = "Dissonant Symphony Spell";
        description = "You pick one target within 6 spaces. If you choose to activate the spell this turn, the target of your spell must succeed on an I vs I roll against you, or else suffer your damage roll ranging from (1-I Bonus) +1. However, if you choose to charge this spell instead of activating it, each turn that you charge it adds a   -2 penalty to the Intelligence roll faced by the enemy, and one additional damage roll from you. If you are successfully attacked while charging the spell, the spell fails. It is also expended unless the you choose to suffer the total damage roll that you had charged (Standard Action/once per game).";
    }
}
