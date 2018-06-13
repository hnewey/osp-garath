package net.castleadventure.ospgarath.model.room.baseRooms;

import net.castleadventure.ospgarath.model.room.Room;
import net.castleadventure.ospgarath.model.room.RoomType;

public class OrangeRoom extends Room {

    public OrangeRoom() {
        roomType = RoomType.ORANGE;
    }

    @Override
    public void initializeRoom() {
        if (connectingRooms.isEmpty()) {
            addConnectingRooms();
        }
    }

}
