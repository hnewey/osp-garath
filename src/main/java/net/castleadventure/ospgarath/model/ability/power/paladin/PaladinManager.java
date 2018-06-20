package net.castleadventure.ospgarath.model.ability.power.paladin;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class PaladinManager extends PowerManager {

    public PaladinManager() {
        classPowers.add(new AdamantDefense());
        classPowers.add(new Avenger());
        classPowers.add(new Convictor());
        classPowers.add(new Defender());
        classPowers.add(new Fanatic());
        classPowers.add(new Protector());
        classPowers.add(new Revitalize());
        classPowers.add(new Zealot());
    }
}
