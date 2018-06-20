package net.castleadventure.ospgarath.model.ability.power.champion;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class ChampionManager extends PowerManager {

    public ChampionManager() {
        classPowers.add(new Challenge());
        classPowers.add(new Charge());
        classPowers.add(new CombatAssistance());
        classPowers.add(new Counterstrike());
        classPowers.add(new Flourish());
        classPowers.add(new MercurialDefense());
        classPowers.add(new RiposeRemise());
        classPowers.add(new Sweep());
    }
}
