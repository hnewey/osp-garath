package net.castleadventure.ospgarath.model.ability.power.burglar;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class BurglarManager extends PowerManager {

    public BurglarManager() {
        classPowers.add(new Backstabber());
        classPowers.add(new Charlatan());
        classPowers.add(new DaggerFlick());
        classPowers.add(new Knave());
        classPowers.add(new Miscreant());
        classPowers.add(new Rapscallion());
        classPowers.add(new Rascal());
        classPowers.add(new Scalawag());
        classPowers.add(new Scoundrel());
        classPowers.add(new Sidestep());
        classPowers.add(new Thief());
        classPowers.add(new Varlet());
    }
}
