package net.castleadventure.ospgarath.model.ability.power.brawler;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class BrawlerManager extends PowerManager {

    public BrawlerManager() {
        classPowers.add(new ArmBar());
        classPowers.add(new BearHug());
        classPowers.add(new Finisher());
        classPowers.add(new GroundPound());
        classPowers.add(new Haymaker());
        classPowers.add(new Lariat());
        classPowers.add(new Overwhelm());
        classPowers.add(new Scrapper());
        classPowers.add(new ShootIn());
        classPowers.add(new ShoulderThrow());
        classPowers.add(new Tactical());
        classPowers.add(new Wrestler());
    }
}
