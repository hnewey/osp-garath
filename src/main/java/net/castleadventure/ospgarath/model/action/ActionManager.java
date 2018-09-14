package net.castleadventure.ospgarath.model.action;

import net.castleadventure.ospgarath.game.Board;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.game.SpaceInfo;
import net.castleadventure.ospgarath.model.character.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionManager {

    private Map<Integer, Character> characters = new HashMap<>();

    //Singleton eager instantiation
    private static ActionManager instance = new ActionManager();
    private ActionManager() {}
    public static ActionManager getInstance() {
        return instance;
    }

    public void addCharacter(Character character) {
        characters.put(characters.size(), character);
    }

    public void removeCharacter(int index) {
        characters.remove(index);
    }

    public List<String> getQuickActions() {
        List<String> actions = new ArrayList<>();

        //TODO: Create possible actions based on position, inventory, and adjacent objects, etc
        actions.add(QuickAction.EQUIP_ITEM.toString());
        actions.add(QuickAction.STORE_ITEM.toString());
        actions.add(QuickAction.POWER.toString());
        actions.add(QuickAction.RESIST_CONDITION.toString());
        return actions;
    }

    public List<String> getStandardActions() {
        List<String> actions = new ArrayList<>();

        Character playerCharacter = GameState.getInstance().getPlayerCharacter();
        int x = playerCharacter.getPosition().getX();
        int y = playerCharacter.getPosition().getY();

        if (Board.getInstance().getSpaceInfo(x, y).equals(SpaceInfo.DOOR)) {
            actions.add(StandardAction.ENTER_ROOM.toString());
        }

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
