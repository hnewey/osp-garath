package net.castleadventure.ospgarath.model.character.monster.monsterTypes;

import net.castleadventure.ospgarath.model.character.Stat;
import net.castleadventure.ospgarath.model.character.monster.Monster;
import net.castleadventure.ospgarath.model.character.monster.monsterTypes.BaseMonster;

public class Minion extends Monster {

    public Minion() {
        copyStats(new BaseMonster());
        statBoostMin = 0;
        statBoostMax = 8;

        endurance = new Stat(1);
        //TODO: ability factory for minion abilities
    }

    @Override
    public String getPlayerName() {
        return null;
    }

    @Override
    public void setPlayerName(String playerName) {

    }
}
