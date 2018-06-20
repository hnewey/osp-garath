package net.castleadventure.ospgarath.model.ability.power.mariner;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class MarinerManager extends PowerManager {

    public MarinerManager() {
        classPowers.add(new CalledShot());
        classPowers.add(new CorsairsDice());
        classPowers.add(new Courage());
        classPowers.add(new DevastatingBlow());
        classPowers.add(new DirtyTrick());
        classPowers.add(new MarinersMark());
        classPowers.add(new PressGang());
        classPowers.add(new RankBreaker());
    }
}
