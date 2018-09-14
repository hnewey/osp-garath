package net.castleadventure.ospgarath.model.character;

import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.character.condition.NegativeCondition;
import net.castleadventure.ospgarath.model.character.condition.PositiveCondition;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.characterClass.ClassType;
import org.json.JSONObject;

import java.util.List;

public class PlayerCharacter extends Character {

    private String playerName;

    public PlayerCharacter() {}

    public PlayerCharacter(int s, int q, int i, int l, int e, int m) {
        super(s, q, i, l, e, m);
    }

    public static Character createFromJson(net.minidev.json.JSONObject json) throws Exception {
        JSONObject newJson = new JSONObject(json.toString());
        JSONObject abilities = newJson.getJSONObject("abilities");
        Integer s = abilities.getInt("strength"), q = abilities.getInt("quickness"), i = abilities.getInt("intelligence"),
                l = abilities.getInt("leadership"), e = abilities.getInt("endurance"), m = abilities.getInt("movement");
        Character character = new PlayerCharacter(s, q, i, l, e, m);
        character.setCharacterClass(ClassType.getClassByName(abilities.getString("class")));
        character.setCharacterRace(Race.getRace(abilities.getString("race")));

        String[] powers = newJson.getJSONArray("powers").getString(0).split(",");
        String className = character.getCharacterClass().getClassName();
        for (String power : powers) {
            character.addPower(PowerManager.getClassPower(className, power.trim()));
        }
        return character;
    }

    @Override
    public void startTurn() {
        conditionManager.maintainConditions();
    }

    @Override
    public void endTurn() {
    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
