package net.castleadventure.ospgarath.model.ability.power.mariner;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class CorsairsDice extends Power {

    public CorsairsDice() {
        name = "Corsair's Dice";
        description = "Begin the game with 3 dice; one d8, one d10 and one d12. At any time when a creature within 6 spaces is making a roll with the 20 sided dice, you may roll one of these dice at the same time and announce that you are using the corsair’s dice power. The value of your roll is subtracted from their roll result. If your target’s d20 roll fails as a result, they gain the hampered condition. Each of the three dices may only be used once per game (Free Action/3 times per game).";
    }
}
