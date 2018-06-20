package net.castleadventure.ospgarath.model.ability.power.paladin;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Fanatic extends Power {

    public Fanatic() {
        name = "Fanatic";
        description = "After a successful attack results in a damage roll, you may choose to make a damage roll that reduces your target’s future attack rolls, rather than reducing Endurance points. Your target’s attack rolls remain lowered by this amount for the remainder of combat.  This effect does not stack more than once on the same target (Free Action/3 times per game).";
    }
}
