package net.castleadventure.ospgarath.model.ability.power.necromancer;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class NecromancerManager extends PowerManager {

    public NecromancerManager() {
        classPowers.add(new BloodMagic());
        classPowers.add(new DeathFollower());
        classPowers.add(new Decay());
        classPowers.add(new Lifesap());
        classPowers.add(new Lifesteal());
        classPowers.add(new MourningStar());
        classPowers.add(new ShadowRealm());
        classPowers.add(new ShadowServant());
    }
}
