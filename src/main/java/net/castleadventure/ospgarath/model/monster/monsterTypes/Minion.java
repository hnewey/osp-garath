package net.castleadventure.ospgarath.model.monster.monsterTypes;

import net.castleadventure.ospgarath.model.monster.Monster;
import net.castleadventure.ospgarath.model.monster.monsterTypes.BaseMonster;

public class Minion extends Monster {

    public Minion() {
        copyStats(new BaseMonster());
        statBoostMin = 0;
        statBoostMax = 8;

        endurance = 1;
        //TODO: ability factory for minion abilities
    }
}
