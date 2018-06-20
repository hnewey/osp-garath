package net.castleadventure.ospgarath.model.ability.power.barbarian;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class BarbarianManager extends PowerManager{

    public BarbarianManager() {
        classPowers.add(new Animosity());
        classPowers.add(new Frenzy());
        classPowers.add(new HotBlooded());
        classPowers.add(new Indignation());
        classPowers.add(new Irascible());
        classPowers.add(new Ire());
        classPowers.add(new Umbrage());
        classPowers.add(new Vexed());
    }
}
