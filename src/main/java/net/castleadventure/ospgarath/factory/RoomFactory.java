package net.castleadventure.ospgarath.factory;

import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.room.EntryRoom;
import net.castleadventure.ospgarath.model.room.Room;
import net.castleadventure.ospgarath.model.room.RoomType;
import net.castleadventure.ospgarath.model.room.baseRooms.*;

import java.util.Random;

public final class RoomFactory {

    public static Room generateRoomByType(RoomType type) throws Exception {
        switch (type) {
            case BLUE:
                return new BlueRoom();
            case RED:
                return new RedRoom();
            case YELLOW:
                return new YellowRoom();
            case PURPLE:
                return new PurpleRoom();
            case GREEN:
                return new GreenRoom();
            case ORANGE:
                return new OrangeRoom();
            case BLACK:
                return new BlackRoom();
            case ENTRY:
                return new EntryRoom();
            default:
                throw new Exception("Unsupported room type");
        }
    }

    //TODO: We could turn this into the Factory Method Pattern by having a generateRoom abstract method and
    //subclasses would handle the actual room creation. This may not work best in this case and it may just be best
    //to allow the Object instantiation method to handle the specifics of room creation.

    public static Room generateRandomRoom() {
        Room room = new EntryRoom();
        room.setRoomType(RoomType.generateRandomRoomType());
        //TODO: set traps, monsters, room secret, etc.

        return room;
    }

    /**
     * Generate a room based on the current game difficulty as follows:
     * Every 0.1 difficulty added increases the odds of finding a green, orange, or purple room by 5%
     * Therefore, at difficult 1.0, there is a 50% chance of finding one. From difficulty 2.0 on,
     * the player will only find advanced rooms
     * @return RoomType
     */
    public static Room generateRoom(Room currentRoom) {
        boolean advancedRoom = shouldCreateAdvancedRoom();
        int roomType = new Random().nextInt(3) + 1;

        Room newRoom;
        if (!advancedRoom) {
            switch (roomType) {
                case 1:
                    newRoom = new BlueRoom();
                case 2:
                    newRoom = new RedRoom();
                default:
                    newRoom = new YellowRoom();
            }
        }
        else {
            switch (roomType) {
                case 1:
                    newRoom = new GreenRoom();
                case 2:
                    newRoom = new OrangeRoom();
                default:
                    newRoom = new PurpleRoom();
            }
        }
        newRoom.setPreviousRoom(currentRoom);
        return newRoom;
    }

    private static boolean shouldCreateAdvancedRoom() {
        float difficulty = GameState.getInstance().getDifficulty();
        if (difficulty == 0.0) {
            return false;
        }
        if (difficulty >= 2.0) {
            return true;
        }

        float advancedRoomOdds = difficulty * 50;
        return (advancedRoomOdds < (new Random().nextInt(100) + 1));
    }
}
