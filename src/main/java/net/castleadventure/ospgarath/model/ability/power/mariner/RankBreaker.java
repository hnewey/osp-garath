package net.castleadventure.ospgarath.model.ability.power.mariner;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class RankBreaker extends Power {

    public RankBreaker() {
        name = "Rank Breaker";
        description = "Any time a power with the word “command” in its name or description is used, you may choose to immediately interrupt and take either a movement or an action before that power is activated. The enemy must then attempt to complete the use of the announced power (Free action/unlimited).";
    }
}
