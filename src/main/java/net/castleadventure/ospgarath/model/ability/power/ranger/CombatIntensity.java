package net.castleadventure.ospgarath.model.ability.power.ranger;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class CombatIntensity extends Power {

    public CombatIntensity() {
        name = "Combat Intensity";
        description = "After a successful attack, you may decide to attack again immediately. If successful, the resulting attack deals an additional damage roll, even if the attack is not one that would normally deal damage (Free Action/1 time per game).";
    }
}
