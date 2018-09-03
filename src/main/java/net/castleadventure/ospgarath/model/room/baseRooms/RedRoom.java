package net.castleadventure.ospgarath.model.room.baseRooms;

import net.castleadventure.ospgarath.factory.MonsterFactory;
import net.castleadventure.ospgarath.model.character.monster.MonsterLevel;
import net.castleadventure.ospgarath.model.room.Room;
import net.castleadventure.ospgarath.model.room.RoomType;

public class RedRoom extends Room {

    public RedRoom() {
        roomType = RoomType.RED;
        try {
            monsters.add(MonsterFactory.getMonster(MonsterLevel.MINION));
        } catch (Exception e) {
            System.err.println("Error creating monster");
        }
    }

    @Override
    public void initializeRoom() {
        if (connectingRooms.isEmpty()) {
            addConnectingRooms();
        }
    }
}
