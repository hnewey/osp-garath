package net.castleadventure.ospgarath.model.ability.power.mage;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class MageManager extends PowerManager {

    public MageManager() {
        classPowers.add(new ArcaneTether());
        classPowers.add(new Endgame());
        classPowers.add(new ForcePulse());
        classPowers.add(new ReverberatingAttack());
        classPowers.add(new StunAttack());
        classPowers.add(new WiseAttack());
        classPowers.add(new WitchHunter());
        classPowers.add(new WizardBane());
    }
}
