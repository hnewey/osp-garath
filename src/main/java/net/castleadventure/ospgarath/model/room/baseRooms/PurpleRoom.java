package net.castleadventure.ospgarath.model.room.baseRooms;

import net.castleadventure.ospgarath.model.room.Room;
import net.castleadventure.ospgarath.model.room.RoomType;

public class PurpleRoom extends Room {

    public PurpleRoom() {
        roomType = RoomType.PURPLE;
    }

    @Override
    public void initializeRoom() {
        if (connectingRooms.isEmpty()) {
            addConnectingRooms();
        }
    }

}
