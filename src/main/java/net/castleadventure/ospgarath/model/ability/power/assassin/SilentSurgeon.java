package net.castleadventure.ospgarath.model.ability.power.assassin;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class SilentSurgeon extends Power {

    public SilentSurgeon() {
        name = "Silent Surgeon";
        description = "You make an attack roll of any kind against a target of your choice. This roll is increased by 1d2 for each of your teammates adjacent to the target. A successful roll causes your target to gain either the bleeding, shaken, staggered, or immobilized condition. Additionally, for each additional roll amount of five by which you succeed your roll, you may choose to add an extra damage roll or another condition.";
    }

}
