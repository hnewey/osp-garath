package net.castleadventure.ospgarath.game;

public class Space {

    private int x;
    private int y;
    private SpaceInfo spaceInfo;

    public Space() {
    }

    public Space(int x, int y) {
        if (Math.abs(x) + Math.abs(y) > 9) {
            System.err.println("Invalid position");
        }
        this.x = x;
        this.y = y;

        spaceInfo = SpaceInfo.FREE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public SpaceInfo getSpaceInfo() {
        return spaceInfo;
    }

    public void setSpaceInfo(SpaceInfo spaceInfo) {
        this.spaceInfo = spaceInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Space)) {
            return false;
        }
        Space position = (Space) o;
        return position.getX() == this.x && position.getY() == this.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + "): " + spaceInfo.toString();
    }
}
