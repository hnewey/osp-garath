package net.castleadventure.ospgarath.model.ability.power.shepherd;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class PackLeader extends Power {

    public PackLeader() {
        name = "Pack Leader";
        description = "When adjacent to your trusted pet, you may add 1d8 to any of its attack rolls. The dice size reduces to a d7 when the trusted pet is two spaces away from the shepherd, a d6 when three spaces away, and so on to merely a +1 when 8 spaces away. (Innate/ unlimited).";
    }
}
