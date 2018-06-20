package net.castleadventure.ospgarath.model.ability.power.outrider;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Trample extends Power {

    public Trample() {
        name = "Trample";
        description = "When riding your animal mount, you or your mount may attempt to move through the space of an enemy character. That enemy must immediately succeed at an S vs S roll against your mount, or else suffer a damage roll from your mount and be knocked over. You may then complete the rest of your movement, regardless of whether or not the attempt was successful. This movement provokes no free attack from your target (Free Action/three times per game).";
    }
}
