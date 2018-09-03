package net.castleadventure.ospgarath.model.character.monster.monsterTypes;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.model.character.Stat;
import net.castleadventure.ospgarath.model.character.monster.Monster;

import java.util.Random;

public class Trooper extends Monster {

    private int maxEndurance = 4;
    private int minEndurance = 3;

    public Trooper() {
        copyStats(new BaseMonster());
        statBoostMin = 3;
        statBoostMax = 10;

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
