package net.castleadventure.ospgarath.model.action;

public class ActionResult {

    private Boolean quickAction;
    private Boolean stdAction;
    private String actionType;
    private String actionResult;

    public ActionResult() {}

    public ActionResult(Boolean quickAction, String actionType, String actionResult) {
        this.quickAction = quickAction;
        this.stdAction = !quickAction; //If it isn't a quick action, it must be a standard action
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
