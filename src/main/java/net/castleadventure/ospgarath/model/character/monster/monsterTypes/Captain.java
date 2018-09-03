package net.castleadventure.ospgarath.model.character.monster.monsterTypes;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.model.character.Stat;
import net.castleadventure.ospgarath.model.character.monster.Monster;

import java.util.Random;

public class Captain extends Monster {

    private int maxEndurance = 4;
    private int minEndurance = 3;

    public Captain() {
        copyStats(new BaseMonster());
        statBoostMin = 4;
        statBoostMax = 14;

        Random random = new Random();
        endurance = new Stat(Dice.dRange(minEndurance, maxEndurance));
        //TODO: ability factory for trooper abilities
    }

    @Override
    public String getPlayerName() {
        return null;
    }

    @Override
    public void setPlayerName(String playerName) {

    }
}
