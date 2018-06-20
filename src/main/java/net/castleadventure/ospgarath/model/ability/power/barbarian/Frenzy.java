package net.castleadventure.ospgarath.model.ability.power.barbarian;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Frenzy extends Power {

    public Frenzy() {
        name = "Frenzy";
        description = "You gain the Determined condition. However, all enemies attacking you act as though they have the Determined condition when attacking you. This must be maintained each round like any other positive condition (Free Action/3 times per game).";
    }
}
