package net.castleadventure.ospgarath.model.ability.power.sovereign;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class SovereignManager extends PowerManager {

    public SovereignManager() {
        classPowers.add(new FaithfulFollowers());
        classPowers.add(new FieldLeadership());
        classPowers.add(new HighbornTraining());
        classPowers.add(new InspiringCry());
        classPowers.add(new NobleRecruits());
        classPowers.add(new RallyingSpeech());
        classPowers.add(new StrategicSteward());
        classPowers.add(new SustainingSteward());
    }
}
