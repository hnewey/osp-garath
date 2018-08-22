package net.castleadventure.ospgarath.model.action;

public class ActionResult {

    Boolean quickAction;
    Boolean stdAction;
    String actionType;
    String actionResult;

    public ActionResult() {}

    public ActionResult(Boolean quickAction, Boolean stdAction, String actionType, String actionResult) {
        this.quickAction = quickAction;
        this.stdAction = stdAction;
        this.actionType = actionType;
        this.actionResult = actionResult;
    }

    public Boolean getQuickAction() {
        return quickAction;
    }

    public void setQuickAction(Boolean quickAction) {
        this.quickAction = quickAction;
    }

    public Boolean getStdAction() {
        return stdAction;
    }

    public void setStdAction(Boolean stdAction) {
        this.stdAction = stdAction;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionResult() {
        return actionResult;
    }

    public void setActionResult(String actionResult) {
        this.actionResult = actionResult;
    }
}
