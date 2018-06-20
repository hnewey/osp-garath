package net.castleadventure.ospgarath.model.ability.power.healer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class AttendingPhysician extends Power {

    public AttendingPhysician() {
        name = "Attending Physician";
        description = "When healing a teammate’s poisoning, or treating a teammate that is attempting to resist a disease, you may add an additional 1d10 to the applicable heal or resist roll of the d20. Additionally, you add 1d8 to all rolls made to diagnose a disease or poison. (Innate/ unlimited).";
    }
}
