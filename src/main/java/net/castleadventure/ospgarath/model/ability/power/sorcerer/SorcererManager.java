package net.castleadventure.ospgarath.model.ability.power.sorcerer;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class SorcererManager extends PowerManager {

    public SorcererManager() {
        classPowers.add(new AstralBurst());
        classPowers.add(new CompoundingTorment());
        classPowers.add(new MindFlayer());
        classPowers.add(new PrimalSiphon());
        classPowers.add(new PrimordialWell());
        classPowers.add(new RangedTouch());
        classPowers.add(new ReplicatedSpell());
        classPowers.add(new TributaryOfPain());
    }
}
