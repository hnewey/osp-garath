package net.castleadventure.ospgarath.model.room.baseRooms;

import net.castleadventure.ospgarath.model.room.Room;
import net.castleadventure.ospgarath.model.room.RoomType;

public class BlackRoom extends Room {

    public BlackRoom() {
        roomType = RoomType.BLACK;
    }

    @Override
    public void initializeRoom() {
        if (connectingRooms.isEmpty()) {
            addConnectingRooms();
        }
    }

}
