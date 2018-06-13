package net.castleadventure.ospgarath.model.monster.monsterTypes;

import net.castleadventure.ospgarath.model.monster.Monster;

import java.util.Random;

public class Trooper extends Monster {

    private int maxEndurance = 4;
    private int minEndurance = 3;

    public Trooper() {
        copyStats(new BaseMonster());
        statBoostMin = 3;
        statBoostMax = 10;

        Random random = new Random();
        endurance = random.nextInt(maxEndurance) + minEndurance;
        //TODO: ability factory for trooper abilities
    }
}
