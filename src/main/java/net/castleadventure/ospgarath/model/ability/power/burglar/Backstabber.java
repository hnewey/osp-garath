package net.castleadventure.ospgarath.model.ability.power.burglar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Backstabber extends Power {

    public Backstabber() {
        name = "Backstabber";
        description = "When attacking an enemy that is either unaware of you, or adjacent to one of your teammates and who has attacked or been attacked by that teammate within the last round, you gain a +2 to attack roll and +1d2 to your damage roll. (Innate/unlimited).";
    }
}
