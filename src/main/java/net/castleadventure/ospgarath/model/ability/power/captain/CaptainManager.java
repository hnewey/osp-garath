package net.castleadventure.ospgarath.model.ability.power.captain;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class CaptainManager extends PowerManager {

    public CaptainManager() {
        classPowers.add(new BattlefieldManeuvers());
        classPowers.add(new Counter());
        classPowers.add(new EncouragingCall());
        classPowers.add(new LeadCharge());
        classPowers.add(new MenacingThreat());
        classPowers.add(new PervasiveLeadership());
        classPowers.add(new PressAdvantage());
        classPowers.add(new Redouble());
        classPowers.add(new SagelyWisdom());
        classPowers.add(new ShelterStorm());
        classPowers.add(new SoundTheHorn());
        classPowers.add(new SteadyingPresence());
    }
}
