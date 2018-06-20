package net.castleadventure.ospgarath.model.ability.power.scholar;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class ScholarManager extends PowerManager {

    public ScholarManager() {
        classPowers.add(new Anthropologist());
        classPowers.add(new Antiquarian());
        classPowers.add(new Apothecary());
        classPowers.add(new Archaeologist());
        classPowers.add(new Demographer());
        classPowers.add(new Economist());
        classPowers.add(new Linguist());
        classPowers.add(new Pathologist());
        classPowers.add(new Philologist());
        classPowers.add(new Phrenologist());
        classPowers.add(new Recanteur());
        classPowers.add(new Statistician());
    }
}
