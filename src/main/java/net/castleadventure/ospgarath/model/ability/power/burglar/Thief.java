package net.castleadventure.ospgarath.model.ability.power.burglar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Thief extends Power {

    public Thief() {
        name = "Thief";
        description = "You make a pickpocket roll against a target enemy. If successful, you may choose to steal any one inventory item or equipped item, other than items in the armor inventory slot (Quick Action/once per game).";
    }
}
