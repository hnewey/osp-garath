package net.castleadventure.ospgarath.model.ability.power.hunter;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class HunterManager extends PowerManager {

    public HunterManager() {
        classPowers.add(new BigGameHunter());
        classPowers.add(new CleanCarve());
        classPowers.add(new ClipShot());
        classPowers.add(new CorneringPrey());
        classPowers.add(new DangerousGame());
        classPowers.add(new DropSpear());
        classPowers.add(new Furrier());
        classPowers.add(new HuntMaster());
    }
}
