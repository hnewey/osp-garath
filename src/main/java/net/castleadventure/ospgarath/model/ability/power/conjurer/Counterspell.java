package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Counterspell extends Power {

    public Counterspell() {
        name = "Counterspell";
        description = "You may immediately interrupt and make an I vs I roll against any character attempting to use a non-unlimited power within 6 spaces. If your roll is successful, the use of that power fails and is lost. If the character is attempting to use a power with the word “spell” in its name or description, you may choose to automatically block the power from being used rather than rolling for it to fail, in which case their power is not expended but that character’s action is lost for the turn. This power cannot be used against another character’s “Counterspell” power. (Standard Action/3 times per game).";
    }
}
