package net.castleadventure.ospgarath.model.room.baseRooms;

import net.castleadventure.ospgarath.model.room.Room;
import net.castleadventure.ospgarath.model.room.RoomType;

public class GreenRoom extends Room {

    public GreenRoom() {
        roomType = RoomType.GREEN;
    }

    @Override
    public void initializeRoom() {
        if (connectingRooms.isEmpty()) {
            addConnectingRooms();
        }
    }

}
