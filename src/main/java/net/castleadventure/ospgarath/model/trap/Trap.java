package net.castleadventure.ospgarath.model.trap;

public abstract class Trap {

    private int location_x;
    private int location_y;

    public String getLocation() {
        return '(' + location_x + ", " + location_y + ')';
    }
}
