package net.castleadventure.ospgarath.model.ability.power.mage;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class WizardBane extends Power {

    public WizardBane() {
        name = "Wizardbane";
        description = "Any time a power with the word “spell” in its name or description is used, you may choose to immediately interrupt and take either a movement or an action before that power is activated. The enemy must then attempt to complete the use of the announced power (Free action/unlimited).";
    }
}
