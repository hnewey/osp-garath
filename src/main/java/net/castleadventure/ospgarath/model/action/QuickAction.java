package net.castleadventure.ospgarath.model.action;

public enum QuickAction {

    EQUIP_ITEM("Equip Item"),
    STORE_ITEM("Store Item"),
    PASS_ITEM("Pass Item"),
    SEARCH_BODY("Search Body"),
    SEARCH_CONTAINER("Search Container"),
    RESIST_CONDITION("Resist Condition"),
    PICK_UP("Pick Up Item"),
    POWER("Power");

    private String action;

    QuickAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return this.action;
    }
}
