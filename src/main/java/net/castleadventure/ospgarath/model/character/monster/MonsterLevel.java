package net.castleadventure.ospgarath.model.character.monster;

import com.fasterxml.jackson.annotation.JsonCreator;
import net.castleadventure.ospgarath.game.GameState;

import java.util.Random;

public enum MonsterLevel {
    MINION(1, "Minion"),
    TROOPER(2, "Trooper"),
    CAPTAIN(3, "Captain"),
    VILLAIN_1(4, "Villain lvl 1"),
    VILLAIN_2(5, "Villain lvl 2"),
    VILLAIN_3(6, "Villain lvl 3");

    private int value;
    private String type;

    private static final int NUM_TYPES = 7;

    MonsterLevel(int value, String type) {
        this.value = value;
        this.type = type;
    }

    public int getValue(){
        return value;
    }

    public String getType() {
        return type;
    }

    @JsonCreator
    public static MonsterLevel getMonsterLevel(int value) {
        for(MonsterLevel monsterLevel : MonsterLevel.values()){
            if(monsterLevel.value == value){
                return monsterLevel;
            }
        }
        throw new IllegalArgumentException();
    }

    public static MonsterLevel generateRandomMonsterLevel() {
        int range = MonsterLevel.values().length;
        if (!GameState.getInstance().getFinalChallengeUnlocked()) {
            range--;
        }
        Random random = new Random();
        int value = random.nextInt(range) + 1;

        return getMonsterLevel(value);
    }

}
