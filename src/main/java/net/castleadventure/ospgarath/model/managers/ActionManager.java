package net.castleadventure.ospgarath.model.managers;

import net.castleadventure.ospgarath.game.Space;
import net.castleadventure.ospgarath.model.action.QuickAction;
import net.castleadventure.ospgarath.model.action.StandardAction;

import java.util.ArrayList;
import java.util.List;

public class ActionManager {

    public static List<String> getQuickActions(Space characterPosition) {
        List<String> actions = new ArrayList<>();

        //TODO: Create possible actions based on position, inventory, and adjacent objects, etc
        actions.add(QuickAction.EQUIP_ITEM.toString());
        actions.add(QuickAction.STORE_ITEM.toString());
        actions.add(QuickAction.POWER.toString());
        actions.add(QuickAction.RESIST_CONDITION.toString());
        return actions;
    }

    public static List<String> getStandardActions(Space characterPosition) {
        List<String> actions = new ArrayList<>();

        //TODO: Create possible actions based on position, inventory, and adjacent objects, etc
        actions.add(StandardAction.STD_ATTACK.toString());
        actions.add(StandardAction.QUICK_ATTACK.toString());
        actions.add(StandardAction.SPECIAL_ATTACK.toString());
        actions.add(StandardAction.EVALUATE_ENEMY.toString());
        actions.add(StandardAction.EVALUATE_AREA.toString());
        actions.add(StandardAction.POWER.toString());
        actions.add(StandardAction.PASS.toString());
        return actions;
    }
}
