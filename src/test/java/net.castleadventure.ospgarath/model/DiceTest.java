package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.game.Dice;
import org.junit.Test;

public class DiceTest {

    @Test
    public void diceRange_test() {
        Integer upper = 10;
        Integer lower = 3;

        for (int i = 0; i < 500; i++) {
            Integer value = Dice.dRange(lower, upper);
            assert (value <= 10 && value >= 3);
        }
    }
}
