package net.castleadventure.ospgarath.model.ability.power.bard;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class BardManager extends PowerManager {

    public BardManager() {
        classPowers.add(new AirEpicaricacy());
        classPowers.add(new ClairvoyantChorus());
        classPowers.add(new DescantDusk());
        classPowers.add(new InspiringAnthem());
        classPowers.add(new SensitiveBallard());
        classPowers.add(new SilverLining());
        classPowers.add(new StoicSong());
        classPowers.add(new SweetMelody());
    }
}
