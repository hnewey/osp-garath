package net.castleadventure.ospgarath.model.ability.power.burglar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Scoundrel extends Power {

    public Scoundrel() {
        name = "Scoundrel";
        description = "After a successful attack roll is made against you, you may cause it to instead strike an adjacent ally, if you can succeed on a Q vs L against that ally (Free Action/once per game).";
    }
}
