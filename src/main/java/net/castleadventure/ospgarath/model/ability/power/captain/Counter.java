package net.castleadventure.ospgarath.model.ability.power.captain;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Counter extends Power {

    public Counter() {
        name = "Counter Command";
        description = "You may immediately interrupt and make an L vs L roll against any character attempting to use a non-unlimited power within 6 spaces. If your roll is successful, the use of that power fails and is lost. If the character is attempting to use a power with the word “command” in its name or description, you may choose to automatically block the power from being used rather than causing it to fail, in which case their power is not expended but that character’s action is lost for the turn. This power cannot be used against another character’s “Counter Command” power (Free action/3 times per game).";
    }
}
