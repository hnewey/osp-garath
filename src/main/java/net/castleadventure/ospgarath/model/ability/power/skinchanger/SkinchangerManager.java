package net.castleadventure.ospgarath.model.ability.power.skinchanger;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class SkinchangerManager extends PowerManager {

    public SkinchangerManager() {
        classPowers.add(new BiteHeels());
        classPowers.add(new FellingThePrey());
        classPowers.add(new Ferocity());
        classPowers.add(new HuntingParty());
        classPowers.add(new Mauler());
        classPowers.add(new PackTactics());
        classPowers.add(new Primal());
        classPowers.add(new Wereform());
    }
}
