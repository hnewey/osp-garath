package net.castleadventure.ospgarath.model.action;

public enum StandardAction {

    STD_ATTACK("Standard Attack"),
    QUICK_ATTACK("Quick Attack"),
    SPECIAL_ATTACK("Special Attack"),
    EVALUATE_ENEMY("Evaluate Enemy"),
    EVALUATE_AREA("Evaluate Area"),
    SEARCH_BODY("Search Body"),
    SEARCH_CONTAINER("Search Container"),
    EXCHANGE_ITEM("Exchange Item"),
    PASS("Skip Turn"),
    POWER("Power");

    private String action;

    StandardAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return this.action;
    }

}
