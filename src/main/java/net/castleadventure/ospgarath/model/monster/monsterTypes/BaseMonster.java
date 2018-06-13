package net.castleadventure.ospgarath.model.monster.monsterTypes;

import net.castleadventure.ospgarath.model.monster.Monster;

import java.util.ArrayList;

public class BaseMonster extends Monster {

    private int baseStat = 6;

    public BaseMonster() {
        strength = baseStat;
        quickness = baseStat;
        intelligence = baseStat;
        leadership = baseStat;
        endurance = 1;
        abilities = new ArrayList<>();
        equippedItems = new ArrayList<>();
        inventory = new ArrayList<>();
    }
}
