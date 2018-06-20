package net.castleadventure.ospgarath.model.ability.power.alchemist;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class AlchemistManager extends PowerManager {

    public AlchemistManager() {
        classPowers.add(new BolsteringPotion());
        classPowers.add(new CorosivePotion());
        classPowers.add(new DuplicatedPotion());
        classPowers.add(new ExplodingPotion());
        classPowers.add(new FieldAlchemy());
        classPowers.add(new FieldBrew());
        classPowers.add(new FluidFortune());
        classPowers.add(new ImprovisedBomb());
        classPowers.add(new PotionConversion());
        classPowers.add(new ShadowFacade());
        classPowers.add(new SmokeBomb());
        classPowers.add(new WateredDown());
    }
}
