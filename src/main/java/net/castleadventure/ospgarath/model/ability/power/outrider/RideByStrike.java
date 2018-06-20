package net.castleadventure.ospgarath.model.ability.power.outrider;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class RideByStrike extends Power {

    public RideByStrike() {
        name = "Ride-By Strike";
        description = "When riding your animal mount, target an enemy with a ranged attack and make a movement towards it. For every two spaces that were you able to move towards it before attacking, you get a +1 bonus to your attack roll. If your attack is successful, you may roll damage as though it were a melee attack. If the attack fails, the power is not expended (Movement & Standard Action/three times per game).";
    }
}
