package net.castleadventure.ospgarath.model.ability.power.conjurer;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;

public class ConjurerManager extends PowerManager {

    public ConjurerManager() {
        classPowers.add(new ArcaneCombat());
        classPowers.add(new Bitter());
        classPowers.add(new Counterspell());
        classPowers.add(new Devastating());
        classPowers.add(new Disarming());
        classPowers.add(new DissonantSymphony());
        classPowers.add(new Echo());
        classPowers.add(new FarReaching());
        classPowers.add(new Incendiary());
        classPowers.add(new Quickened());
        classPowers.add(new Spontaneous());
        classPowers.add(new StrenuousAffliction());
    }
}
