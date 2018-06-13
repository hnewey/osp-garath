package net.castleadventure.ospgarath.model.room;

public class RoomEval {

    private int rollRequired;
    private String eval;

    public RoomEval(int rollRequired, String eval) {
        this.rollRequired = rollRequired;
        this.eval = eval;
    }

    @Override
    public String toString() {
        return rollRequired + "-" + eval;
    }
}
