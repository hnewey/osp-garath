package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;

public abstract class NegativeCondition extends Condition {

    protected Type conditionType;

    public NegativeCondition() {
        this.rollRequired = 20;
    }

    public Boolean resist() {
        this.rollRequired -= 5;
        if (rollRequired <= 0) {
            rollRequired = 1; //a natural 1 will be a critical failure but 1 after modifiers still passes
        }
        return Dice.d20() >= rollRequired;
    }

    public enum Type {
        HAMPERED(),
        BLEEDING(),
        IMMOBILIZED(),
        SLOWED(),
        STAGGERED(),
        WEAKENED()
    }

    public Type getConditionType() {
        return conditionType;
    }
}
