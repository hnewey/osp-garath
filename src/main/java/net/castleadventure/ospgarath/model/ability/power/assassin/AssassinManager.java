package net.castleadventure.ospgarath.model.ability.power.assassin;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class AssassinManager extends PowerManager{

    public AssassinManager() {
        classPowers.add(new BriarThorn());
        classPowers.add(new KnifeInShadows());
        classPowers.add(new Malicious());
        classPowers.add(new Malignant());
        classPowers.add(new SilentSurgeon());
        classPowers.add(new VenomousIncursion());
        classPowers.add(new WayOfVermin());
        classPowers.add(new WayOfViper());
    }
}
