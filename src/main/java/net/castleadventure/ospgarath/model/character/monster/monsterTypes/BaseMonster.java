package net.castleadventure.ospgarath.model.character.monster.monsterTypes;

import net.castleadventure.ospgarath.model.character.Stat;
import net.castleadventure.ospgarath.model.character.monster.Monster;
import net.castleadventure.ospgarath.model.item.Item;

import java.util.ArrayList;

public class BaseMonster extends Monster {

    private Stat baseStat = new Stat(6);

    public BaseMonster() {
        strength = baseStat;
        quickness = baseStat;
        intelligence = baseStat;
        leadership = baseStat;
        endurance = new Stat(1);
        powers = new ArrayList<>();
    }

    @Override
    public String getPlayerName() {
        return null;
    }

    @Override
    public void setPlayerName(String playerName) {

    }
}
