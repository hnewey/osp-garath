package net.castleadventure.ospgarath.model.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import net.castleadventure.ospgarath.game.GameState;

import java.util.Random;

public enum RoomType {
    BLUE(1, "Blue:Mental"),
    RED(2, "Red:Physical"),
    YELLOW(3, "Yellow:Agility"),
    PURPLE(4, "Purple:Mental-Physical"),
    GREEN(5, "Green:Mental-Agility"),
    ORANGE(6, "Orange:Physical-Agility"),
    BLACK(7, "FINAL CHALLENGE"),
    ENTRY(8, "ENTRY ROOM");

    private int value;
    private String type;

    private static final int NUM_TYPES = 7; //Don't include the Entry room as a possible room to come to

    RoomType(int value, String type) {
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
    public static RoomType getRoomType(int value) {
        for(RoomType roomType : RoomType.values()){
            if(roomType.value == value){
                return roomType;
            }
        }
        throw new IllegalArgumentException();
    }

    public static RoomType generateRandomRoomType() {
        int range = NUM_TYPES;
        if (!GameState.getInstance().getFinalChallengeUnlocked()) {
            range = NUM_TYPES - 1;
        }
        Random random = new Random();
        int value = random.nextInt(range) + 1;

        return getRoomType(value);
    }

}
