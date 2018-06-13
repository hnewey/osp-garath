package net.castleadventure.ospgarath.model.character.condition;

public abstract class NegativeCondition extends Condition {

    public NegativeCondition() {
        this.rollRequired = 20;
    }

    public void endTurn() {
        this.rollRequired -= 5;
        if (rollRequired <= 0) {
            rollRequired = 2;
        }
    }
}
