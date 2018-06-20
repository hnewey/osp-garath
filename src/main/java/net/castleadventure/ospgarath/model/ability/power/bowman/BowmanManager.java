package net.castleadventure.ospgarath.model.ability.power.bowman;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.ability.power.bard.InspiringAnthem;

public class BowmanManager extends PowerManager {

    public BowmanManager() {
        classPowers.add(new BlackArrow());
        classPowers.add(new InspiringArcher());
        classPowers.add(new Interloper());
        classPowers.add(new MeleeArcher());
        classPowers.add(new Overdraw());
        classPowers.add(new RelooseRetort());
        classPowers.add(new SwiftPrecision());
        classPowers.add(new TrickShot());
    }
}
