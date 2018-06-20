package net.castleadventure.ospgarath.model.ability.power.sorcerer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class PrimordialWell extends Power {

    public PrimordialWell() {
        name = "Spell of the Primordial Well";
        description = "You may replicate and use any character’s non-unlimited power that has been used within six spaces of you, since the end of your last turn. In order to do this, you must succeed on an I vs I roll against the character whose power you are trying to replicate. If this I vs I roll fails, this power is not expended (Free Action/3 times per game).";
    }
}
