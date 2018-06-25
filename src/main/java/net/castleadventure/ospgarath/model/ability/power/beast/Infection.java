package net.castleadventure.ospgarath.model.ability.power.beast;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Infection extends Power {

    public Infection() {
        name = "Infection";
        description = "Upon a successful attack, in addition to doing damage you may choose to cause a character to become weakened, randomly choosing an ability S,Q,I, or L (Free action/three times per game).";
    }
}
