package net.castleadventure.ospgarath.model.ability.power.shepherd;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class ShepherdManager extends PowerManager {

    public ShepherdManager() {
        classPowers.add(new AnimalExtrasensory());
        classPowers.add(new AnimalStrategy());
        classPowers.add(new Dominant());
        classPowers.add(new Nuisance());
        classPowers.add(new PackLeader());
        classPowers.add(new StrengthHerd());
        classPowers.add(new TamingBeast());
        classPowers.add(new WildCall());
    }
}
