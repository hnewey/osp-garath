package net.castleadventure.ospgarath.factory;

import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.model.character.monster.*;
import net.castleadventure.ospgarath.model.character.monster.monsterTypes.Captain;
import net.castleadventure.ospgarath.model.character.monster.monsterTypes.Minion;
import net.castleadventure.ospgarath.model.character.monster.monsterTypes.Trooper;
import net.castleadventure.ospgarath.model.character.monster.monsterTypes.Villain;

public final class MonsterFactory {

    public static Character getMonster(MonsterLevel monsterLevel) throws Exception {
        Monster createdMonster;
        switch (monsterLevel) {
            case MINION: createdMonster = new Minion();
            break;
            case TROOPER: createdMonster = new Trooper();
            break;
            case CAPTAIN: createdMonster = new Captain();
            break;
            case VILLAIN_1: createdMonster = new Villain(1);
            break;
            case VILLAIN_2: createdMonster = new Villain(2);
            break;
            case VILLAIN_3: createdMonster = new Villain(3);
            break;
            default: throw new Exception("Unsupported Monster Type");
        }
        createdMonster.adjustStats();
        createdMonster.setClassType(StatResolver.getClass(
                createdMonster.getStrength().getValue(),
                createdMonster.getQuickness().getValue(),
                createdMonster.getIntelligence().getValue(),
                createdMonster.getLeadership().getValue()));
        return createdMonster;
    }

    //TODO: Change to Factory Method Pattern by having an abstract createEnemy method here.
    // Subclasses (MinionFactory, TrooperFactory, etc.) will handle creating that enemy

}
