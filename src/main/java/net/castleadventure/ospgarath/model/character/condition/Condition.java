package net.castleadventure.ospgarath.model.character.condition;

public abstract class Condition {
    //TODO: Still need Shaken, Focused, Exhausted, Paralyzed, Freezing conditions

    protected Integer rollRequired;

    public abstract void doEffect();
    public abstract void endEffect();

    public Integer getRollRequired() {
        return rollRequired;
    }
}
