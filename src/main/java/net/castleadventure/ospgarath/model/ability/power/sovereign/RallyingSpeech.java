package net.castleadventure.ospgarath.model.ability.power.sovereign;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class RallyingSpeech extends Power {

    public RallyingSpeech() {
        name = "Rallying Speech Command";
        description = "All of the sovereign’s teammates within 6 spaces can choose to take a turn immediately following the sovereign’s turn, in whatever order the sovereign chooses. If they do so, this replaces their next standard turn in the order and they receive a +1 to defense, +2 to attack rolls, and +1 to movement.  These bonuses persist as long as an enemy is defeated each round (as measured by sovereign’s turn in the order) and as long as the sovereign remains conscious. These characters’ new place in the combat order is permanent until the end of the battle (Free Action/1 time per game).";
    }
}
