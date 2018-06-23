package net.castleadventure.ospgarath.model.ability.power;

public abstract class Power {

    protected String name;
    protected String description;
    protected String imageSrc = "icon/" + getClassNameFromPackage() + "/" + this.getClass().getSimpleName();
    protected String powerCost = "1";
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

    public String getImageSrc() {
        return imageSrc + ".jpg";
    }

    public String getPowerCost() {
        return powerCost;
    }

    public String getClassNameFromPackage() {
        return this.getClass().getPackage().toString().split("power.")[1];
    }
}
