package net.castleadventure.ospgarath.model.ability.power.ranger;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class RangerManager extends PowerManager {

    public RangerManager() {
        classPowers.add(new Ambidextrous());
        classPowers.add(new BeleagueringCompanion());
        classPowers.add(new CombatIntensity());
        classPowers.add(new DeadlyRange());
        classPowers.add(new DualAssault());
        classPowers.add(new HealingHands());
        classPowers.add(new OffHandStrike());
        classPowers.add(new WoundWatcher());
    }
}
