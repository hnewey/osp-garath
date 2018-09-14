package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;

public abstract class PositiveCondition extends Condition{

    protected Type conditionType;

    public PositiveCondition() {
        this.rollRequired = 0;
    }

    public Boolean maintain() {
        this.rollRequired += 5;
        if (rollRequired > 20) {
            rollRequired = 20;
        }
        return Dice.d20() >= rollRequired;
    }

    public enum Type {
        DETERMINED(),
        STEADIED(),
        STRENGTHENED()
    }

    public Type getConditionType() {
        return this.conditionType;
    }
}
