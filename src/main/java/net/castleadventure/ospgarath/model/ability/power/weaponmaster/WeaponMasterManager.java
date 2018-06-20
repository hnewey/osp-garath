package net.castleadventure.ospgarath.model.ability.power.weaponmaster;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class WeaponMasterManager extends PowerManager {

    public WeaponMasterManager() {
        classPowers.add(new Deflect());
        classPowers.add(new ExpertAttack());
        classPowers.add(new KillingStrokes());
        classPowers.add(new Overexertion());
        classPowers.add(new PunishingReaction());
        classPowers.add(new RecklessAbandon());
        classPowers.add(new Refocus());
        classPowers.add(new Sunder());
    }
}
