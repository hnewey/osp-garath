package net.castleadventure.ospgarath.model.character;

public enum StatType {

    STRENGTH("strength"),
    QUICKNESS("quickness"),
    INTELLIGENCE("intelligence"),
    LEADERSHIP("leadership"),
    MOVEMENT("movement"),
    ENDURANCE("endurance"),
    DEFENSE("defense");

    private String type;

    StatType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
