package net.castleadventure.ospgarath.model.ability.power.healer;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class HealerManager extends PowerManager {

    public HealerManager() {
        classPowers.add(new Apothecary());
        classPowers.add(new AttendingPhysician());
        classPowers.add(new ComfortsOfHome());
        classPowers.add(new FieldMedic());
        classPowers.add(new FolkHealer());
        classPowers.add(new Herbalist());
        classPowers.add(new HeroicRevive());
        classPowers.add(new HousesOfHealing());
    }
}
