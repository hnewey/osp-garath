package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;

public abstract class PositiveCondition extends Condition{

    public PositiveCondition() {
        this.rollRequired = 0;
    }

    public void maintain() {
        this.rollRequired += 5;
        if (rollRequired > 20) {
            rollRequired = 20;
        }
    }
}
