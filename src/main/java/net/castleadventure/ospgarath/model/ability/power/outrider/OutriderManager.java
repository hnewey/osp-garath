package net.castleadventure.ospgarath.model.ability.power.outrider;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class OutriderManager extends PowerManager {

    public OutriderManager() {
        classPowers.add(new BornToRide());
        classPowers.add(new LightCharge());
        classPowers.add(new NobleSteed());
        classPowers.add(new OpportunistOffensive());
        classPowers.add(new RideByStrike());
        classPowers.add(new RideToRuin());
        classPowers.add(new ThunderingGait());
        classPowers.add(new Trample());
    }
}
