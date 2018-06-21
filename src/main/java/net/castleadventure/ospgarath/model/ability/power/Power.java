package net.castleadventure.ospgarath.model.ability.power;

public abstract class Power {

    protected String name;
    protected String description;
    //TODO: Make ActionType enum and uses per game variables;

    @Override
    public String toString() {
        return "<i><u>" + name + ":</u></i> " + description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
