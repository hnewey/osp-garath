package net.castleadventure.ospgarath.model.ability.power.paladin;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Convictor extends Power {

    public Convictor() {
        name = "Convictor";
        description = "After a successful attack results in a damage roll, you may choose to make a damage roll that reduces the defense of your target, rather than reducing Endurance points. Your target’s defense remains lowered by this amount for the remainder of combat. This effect does not stack more than once on the same target (Movement and Free Action/3 times per game).";
    }
}
