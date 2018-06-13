package net.castleadventure.ospgarath.model.room.baseRooms;

import net.castleadventure.ospgarath.model.room.Room;
import net.castleadventure.ospgarath.model.room.RoomType;

public class YellowRoom extends Room {

    public YellowRoom() {
        roomType = RoomType.YELLOW;
    }

    @Override
    public void initializeRoom() {
        if (connectingRooms.isEmpty()) {
            addConnectingRooms();
        }
    }

}
